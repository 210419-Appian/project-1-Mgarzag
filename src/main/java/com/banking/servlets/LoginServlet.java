package com.banking.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginServlet extends HttpServlet {
	
	private UserService uService = new UserService();
	private ObjectMapper om = new ObjectMapper();
		
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			resp.setContentType("json");
			String json = om.writeValueAsString(resp);
			PrintWriter out = resp.getWriter();
			System.out.println(json);
			
	    }
		

	}
