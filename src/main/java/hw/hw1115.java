package hw;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/hw/hw1115")
public class hw1115 extends HttpServlet {
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
		
		hw1115VO vo = new hw1115VO(name, classification, products, strnumber, strprice, total, cnt);
		request.setAttribute("vo", vo);
		String viewPage = "/study/hw/hw1115Ok.jsp";
		request.getRequestDispatcher(viewPage).forward(request, response);
		
		
		
	}

}
