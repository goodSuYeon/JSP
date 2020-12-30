package kr.or.ddit.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimesTablesServlet extends HttpServlet {
	
	public void init() throws ServletException{
		System.out.println("basicServlet.init()");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title>basic Servlet</title>");
		out.println("<style>");
		out.println("	td{ ");
		out.println("		border: 1px solid black; }");
		out.println("	table{ ");
		out.println("		width : 100% }");
		out.println("</style>");
		out.println("	</head>");
		out.println("<body>");
		
		out.println("	<table border='1'>");
		for(int i=2; i<=9; i++) {
			out.print("		<tr>");
			out.print("		</tr>");
			 for(int j=1; j<=10; j++) {
		out.print("			<td>" + i + " * " + j + " =" + i*j + "</td>");
			 }
		}
		
		out.print("		</tr>");
		out.println("	</table>");
		out.println("</body>");
		out.println("</html>");
		
		out.flush();	
		out.close();	
	}
	
}
