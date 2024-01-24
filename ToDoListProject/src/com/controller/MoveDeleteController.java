package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BO.ListBO;
import com.BO.ListBO1;
import com.Dao.Listdao;

/**
 * Servlet implementation class MoveDeleteController
 */
@WebServlet("/MoveDeleteController")
public class MoveDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoveDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		int status = Listdao.movedelete(id);
		
		if(status>0)
		{
			pw.print("<script> alert('Data deleted...') </script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("List.html");
			
			rd.include(request, response);
			
		}
		else
		{
			pw.print("<script> alert('Something went wrong...') </script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("List.html");
			
			rd.include(request, response);
			
			
		}
		
		
		
		pw.print("<link rel=\"stylesheet\" href=\"css\\style.css\">");
		
		//pw.print("<a href='admin.html' > <input type='button' id='btn' value='Back'> </a> <br><br>");
		
		
		pw.print("<table width='30%'>");
		pw.print("<br><br>");
		pw.print("<tr> <th>List</th>  <th>Remove</th> <th>Move </th> </tr>");
		 
		
		List<ListBO> list = Listdao.getdata();
		
		for(ListBO sb: list)
		{
			
			pw.print("<tr> <td>  <input type='checkbox'>    " + sb.getList() + "</td><td><a href='DeleteController?id="+sb.getId()+"'> remove </a></td><td><a href='TableController?id="+sb.getId()+"'> move </a></td></tr>");
		}
	
		pw.print("</table>");
		
		// TABLE TWO
		
		pw.print("<link rel=\"stylesheet\" href=\"css\\style.css\">");
		
		//pw.print("<a href='admin.html' > <input type='button' id='btn' value='Back'> </a> <br><br>");
		
		pw.print("<table width='30%'>");
		pw.print("<br><br>");
		pw.print("<tr> <th>List</th>  <th>Remove</th> <th>Move </th> </tr>");
		 
		
		List<ListBO1> list2 = Listdao.getalldata();
		
		for(ListBO1 sb: list2)
		{
			
			pw.print("<tr> <td>  <input type='checkbox'>    " + sb.getList() + "</td><td><a href='MoveDeleteController?id="+sb.getId()+"'> remove </a></td><td><a href='MoveController?id="+sb.getId()+"'> move </a></td></tr>");
		}
	
		pw.print("</table>");

	}


}
