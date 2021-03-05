package com.cartAssignment.springboot.application.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cartAssignment.springboot.application.model.Server;
import com.cartAssignment.springboot.application.service.ServerService;


public class ServerServiceImpl implements ServerService{

	@Override
	public List<Server> getAllServers() {
		List<Server> serverList = new ArrayList<>();
		
		Server serverOne = new Server();
		serverOne.setServerName("Server A");
		BigDecimal price = new BigDecimal(10000);
		
		serverOne.setServerPrice(price);
		
		java.util.Currency cad = java.util.Currency.getInstance("CAD");
		java.text.NumberFormat format = java.text.NumberFormat.getCurrencyInstance(java.util.Locale.CANADA);
		format.setCurrency(cad);
		serverOne.setFormattedPrice(format.format(price));
		
		serverOne.setServerId(1);
		
		Server serverTwo = new Server();
		serverTwo.setServerName("Server B");
		price = new BigDecimal(5000);
		
		serverTwo.setServerPrice(price);
		
		serverTwo.setFormattedPrice(format.format(price));
		
		serverTwo.setServerId(2);
		
		
		serverList.add(serverOne);
		serverList.add(serverTwo);
		return serverList;
	}

}
