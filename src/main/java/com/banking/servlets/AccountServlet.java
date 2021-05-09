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

public class AccountServlet extends HttpServlet {
	
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
		
		//The above is all so that the object mapper can easily read the body
		
		//Jackson will convert the json that is in the body to a java object we tell it to.
		Account a = om.readValue(body, Account.class);
		
		if (aService.addAccount(a)) {
			resp.setStatus(201);
		}else {
			resp.setStatus(400);
		}
	}

}
