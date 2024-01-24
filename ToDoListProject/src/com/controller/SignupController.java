package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BO.UserBO;
import com.Dao.Dao;

/**
 * Servlet implementation class SignupController
 */
@WebServlet("/SignupController")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SignupController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		UserBO ob = new UserBO();
		
		ob.setName(name);
		ob.setEmail(email);
		ob.setUsername(username);
		ob.setPassword(password);
		
		int status = Dao.signup(ob);
		
		if(status > 0)
		{
			pw.print("<script> alert('Signup successfully..') </script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("index.html");	
			rd.include(request, response);
		}
		else
		{
			pw.print("<script> alert('Something went wrong..Please try again') </script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("Signup.html");	
			rd.include(request, response);
		}
		
	}

}
