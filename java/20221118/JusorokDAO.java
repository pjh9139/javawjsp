package study.j1120_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JusorokDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private String sql ="";
	
	JusorokVO vo = null;
	
	public JusorokDAO() {
		String url = "jdbc:mysql://localhost:3306/javaworks";
		String user = "root";
		String password = "1234";
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패");
		} catch (SQLException e) {
			System.out.println("Database 연동 실패");
		}
	}
	// 사용한 객체 반납
	public void pstmtClose() {
		if(pstmt !=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {}
		}
	}
	public void rsClose() {
		if(rs != null) {
			try {
				rs.close();
				pstmtClose();
			} catch (SQLException e) {}
		}
	}
	public JusorokVO loginCheck(String mid, String pwd) {
		vo = new JusorokVO();
		try {
			sql = "select * from jusorok where mid=? and pwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setMid(rs.getString("mid"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setPoint(rs.getInt("point"));
				vo.setLastDate(rs.getString("lastDate"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}
	
	public void logout() {
		
		
	}
	public boolean login(String mid, String pwd) {
		boolean loginCheck = false;
		try {
			sql = "select * from jusorok where mid=? and pwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { loginCheck = true;	}
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			rsClose();
		}
		return loginCheck;
	
	}
	
	
	//회훤 정보 조회
	public JusorokVO getMemberSearch(String mid) {
		vo = new JusorokVO();
		try {
			sql = "select * from jusorok where mid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setMid(rs.getString("mid"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setPoint(rs.getInt("point"));
				vo.setLastDate(rs.getString("lastDate"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}
	// 방문 포인트증가
	public void addPoint(int visitPoint, String mid) {
		try {
			sql = "update jusorok set point=? where mid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, visitPoint);
			pstmt.setString(2, mid);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			pstmtClose();
		}
	}
	
	// 최종방문일자
	public void dayUpdate(String mid) {
		// TODO Auto-generated method stub
		try {
			sql = "update  jusorok set lastDate=now() where mid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			pstmtClose();
		}
	}
	
	// 회원가입처리
	public int setJoinOk(JusorokVO vo) {
		int res = 0 ;
		try {
			sql= "insert into jusorok (mid, pwd, name) values (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.executeUpdate();
			res = 1;
			
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	
	// 전체 회원 조회
	public ArrayList<JusorokVO> getmemberList() {
		ArrayList<JusorokVO> vos = new ArrayList<>();
		try {
			sql = "select * from jusorok order by idx desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new JusorokVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setMid(rs.getString("mid"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setPoint(rs.getInt("point"));
				vo.setLastDate(rs.getString("lastDate"));
				
				vos.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vos;
	}
	
	//cnt 찾기
	public int cnt(String mid) {
		int cnt = 0;
		try {
			sql = "select * from jusorok where mid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			rsClose();
		}
		return cnt;
	}
	
	//cnt 0으로 만들기
	public void cnt0(String mid) {
		try {
			sql = "update jusorok set cnt=0 where mid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			pstmtClose();
		}
	}
	
	//cnt +1 하기
	public void cntPlus(int cnt, String mid) {
		try {
			sql = "update jusorok set cnt=? where mid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cnt);
			pstmt.setString(2, mid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			pstmtClose();
		}
	}
	
	//id중복체크
	public boolean idCheck(String mid) {
		boolean idCheck = true;
		try {
			sql = "select * from jusorok where mid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { idCheck = false;	}
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			rsClose();
		}
		return idCheck;
	}
	//cnt 5로 만들기
	public void cnt5(String mid) {
		try {
			sql = "update jusorok set cnt=5 where mid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			pstmtClose();
		}
	}
	
}
