package com.banking.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banking.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RegisterServlet extends HttpServlet {
	
	private UserService uService = new UserService();
	private ObjectMapper om = new ObjectMapper();
	
	

}
