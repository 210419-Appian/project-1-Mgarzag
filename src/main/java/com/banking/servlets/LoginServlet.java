package com.banking.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banking.models.User;
import com.banking.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginServlet extends HttpServlet {
		
		private UserService uService = new UserService();
		private ObjectMapper om = new ObjectMapper();
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
			List<User> list = uService.getAllUser();
			
		}

	}
