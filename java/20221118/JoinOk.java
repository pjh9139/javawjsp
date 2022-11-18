package study.j1120_database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/database/JoinOk")
public class JoinOk extends HttpServlet{
	@Override
	protected void service(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
		String mid = reqest.getParameter("mid")==null ? "" : reqest.getParameter("mid");
		String pwd = reqest.getParameter("pwd")==null ? "" : reqest.getParameter("pwd");
		String name = reqest.getParameter("name")==null ? "" : reqest.getParameter("name");
		
		JusorokVO vo = new JusorokVO();
		JusorokDAO dao = new JusorokDAO();
		PrintWriter out = response.getWriter();
		
		vo.setMid(mid);
		vo.setPwd(pwd);
		vo.setName(name);
		
		//아이디 중복체크....
		
		// 중복체크후 정상자료일 경우 DB에 저장처리
		boolean idCheck = dao.idCheck(mid);
		if (!idCheck){
			out.println("<script>");
			out.println("alert('아이디가 중복되었습니다');");
			out.println("location.href='"+reqest.getContextPath()+"/study/1120_Database/join.jsp';");
			out.println("</script>");
		} else {
			
			
			int res = dao.setJoinOk(vo);
			if(res == 1) {
				out.println("<script>");
				out.println("alert('"+mid+"님 회원가입을 횐영합니다.');");
				out.println("location.href='"+reqest.getContextPath()+"/study/1120_Database/join.jsp';");
				out.println("</script>");
			}
			else{
				out.println("<script>");
				out.println("alert('회원가입 실패');");
				out.println("location.href='"+reqest.getContextPath()+"/study/1120_Database/join.jsp';");
				out.println("</script>");
			}
		}
	}
}
