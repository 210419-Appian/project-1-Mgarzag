package com.banking.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banking.models.Account;
import com.banking.services.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TransactionServlet extends HttpServlet {
	
	private AccountService aService = new AccountService();
	private ObjectMapper om = new ObjectMapper();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		
		StringBuilder sb = new StringBuilder();
		
		//The request object has a built in method to return an object that can read the body line by line
		BufferedReader reader = req.getReader();
		
		String line = reader.readLine();
		
		while (line != null) {
			sb.append(line);
			//advance to the next line
			line = reader.readLine();
		}
		
		String body = new String(sb);
		
		Account a = om.readValue(body, Account.class);
		
		if (aService.deposit(a)) {
			resp.setStatus(200);
		}else {
			resp.setStatus(400);
		}
		
	}

}
