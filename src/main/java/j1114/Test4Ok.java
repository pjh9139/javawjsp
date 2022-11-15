package j1114;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/j1114/Test4Ok")
public class Test4Ok extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String name = request.getParameter("name");
		String classification = request.getParameter("Classification");
		String[] products = request.getParameterValues("product");
		String[] strprice = request.getParameterValues("price");
		String[] strnumber = request.getParameterValues("number");
		int total = 0;
		int cnt = products.length;
		
		int[] price = new int[cnt] ;
		int[] number = new int[cnt] ;
		for(int i = 0; i <cnt;i++){
			price[i] = Integer.parseInt(strprice[i]);
			number[i] = Integer.parseInt(strnumber[i]);
			total += price[i]*number[i];
		}
		
		test4VO vo = new test4VO(name, classification, products, strprice, strnumber, total);
		request.setAttribute("vo", vo);
		String viewPage = "/study/1114/test4Ok.jsp";
		request.getRequestDispatcher(viewPage).forward(request, response);
		
		
		
	}

}
