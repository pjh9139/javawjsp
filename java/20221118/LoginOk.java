package study.j1120_database;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/database/LoginOk")
public class LoginOk extends HttpServlet{
	@SuppressWarnings("unlikely-arg-type")
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid")==null ? "" : request.getParameter("mid");
		String pwd = request.getParameter("pwd")==null ? "" : request.getParameter("pwd");

		JusorokDAO dao = new JusorokDAO();
		
		boolean login = dao.login(mid,pwd);
		JusorokVO vo = dao.loginCheck(mid,pwd);
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		if(login){
			// 1.자주사용하는 자료를 세션에 담기 2.방문포인트를 10점씩 부가한다.(단, 1일 방문포인트는 50점까지만 허용) 3.최종방문날짜를 현재 날짜로 변경
			session.setAttribute("sMid", mid);
			session.setAttribute("sName", vo.getName());
			session.setAttribute("sLastDate", vo.getLastDate().substring(0,19));
			
			// 2.방문 포인트 증가하기 (10점씩, 1일 50점까지...), 3최종방문일자 업데이트...
			
			LocalDate now = LocalDate.now();
			String lastDate = vo.getLastDate().substring(0,10);
			int cnt = dao.cnt(mid);
			
			if(!lastDate.equals(now)) {
				dao.cnt0(mid);
			}
			if(cnt<5) {
				int visitPoint = vo.getPoint() + 10;
				dao.addPoint(visitPoint,mid);
				dao.cntPlus(cnt+1,mid);
			}else if(cnt==5) {
				dao.cnt5(mid);
			}
			
			//3.최종방문날짜를 현재 날짜로 변경
			dao.dayUpdate(mid);
			
			
			out.println("<script>");
			out.println("alert('"+vo.getName()+"님 로그인되셨습니다.');");
			out.println("location.href='"+request.getContextPath()+"/database/MemberMain';");
			out.println("</script>");
			
//			response.sendRedirect(request.getContextPath()+"/database/MemberMain");
		}
		else {
			out.println("<script>");
			out.println("alert('아이디와 비밀번호를 확인하세요!');");
			out.println("location.href='"+request.getContextPath()+"/study/1120_Database/login.jsp';");
			out.println("</script>");
			
		}
		
	}
}
