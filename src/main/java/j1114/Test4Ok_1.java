package j1114;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/j1114_Test4Ok")
public class Test4Ok_1 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String name = request.getParameter("name");
		String classification = request.getParameter("Classification");
		String[] products = request.getParameterValues("product");
		String[] strprice = request.getParameterValues("price");
		String[] strnumber = request.getParameterValues("number");
		int cnt = products.length;
		
		int[] price = new int[cnt] ;
		int[] number = new int[cnt] ;
		int total = 0;
		for(int i = 0; i <cnt;i++){
			price[i] = Integer.parseInt(strprice[i]);
			number[i] = Integer.parseInt(strnumber[i]);
			total += price[i]*number[i];
		}
			 
		
		
		String strProduct = "";
		
		for(int i=0; i<products.length; i++) {
			if(products[i].trim() != "") {
				strProduct += products[i].trim() + " " +
				price[i]*number[i]
				+"원 <br/>";
			}
		}
		
		PrintWriter out = response.getWriter();
		
		if(!strProduct.equals("")) {
			strProduct = strProduct.substring(0, strProduct.length()-1);
		}
		else {
			out.println("<script>");
			out.println("alert('1개 이상의 상품은 등록하셔야 합니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		out.println("<p>"+name+"님이 등록하신 상품은?</p>");
		out.println(classification+"품목에");
		out.println("<p>"+strProduct+"</p>");
		out.println("해서 총 "+total+"원 입니다!");
		out.println("<script>");
		out.println("alert('상품 등록 완료!');");
		out.println("</script>");
		out.println("<p><a href='"+request.getContextPath()+"/study/1114/test4.jsp'>돌아가기</a>");
	}

}
