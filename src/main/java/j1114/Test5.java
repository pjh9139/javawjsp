package j1114;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet({"/j1114_Test5","/j1114_T5"})
public class Test5 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String name = request.getParameter("name");
		
		PrintWriter out = response.getWriter();
		
		out.println("서블릿에서 View로 출력하기<br/>");
		out.println("hidden으로 전송된 네임 " +name +"<br/>");
		out.println("<p><a href = '"+request.getContextPath()+"/study/1114/test5.jsp'>돌아가기</a></p>");
		out.println("<p><input type='button' value='돌아가기' onclick='location.href=\""+request.getContextPath()+"/study/1114/test5.jsp\"'/></p>");

	}
}
