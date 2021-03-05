package com.cartAssignment.springboot.application.controller;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cartAssignment.springboot.application.model.Server;
import com.cartAssignment.springboot.application.service.ServerService;
import com.cartAssignment.springboot.application.service.impl.ServerServiceImpl;

@Controller
public class ServerController {	
	
	
	private ServerService serverService = new ServerServiceImpl();
	
	
	@RequestMapping("/getAllServers")
	public String getAllServers(ModelMap model){
		List<Server> listServers = serverService.getAllServers();
		model.addAttribute("servers",listServers);
		return "welcome";
	}
	

	
	@RequestMapping("/selected")
	public String selected(@RequestParam("submittedIds") List<Integer> selectedIds,ModelMap model) {
		List<Server> selectedServers = new ArrayList<Server>();
		if(selectedIds!=null && !selectedIds.isEmpty()) {
			List<Server> listServers = serverService.getAllServers();
			selectedServers = listServers.stream().filter(server->selectedIds.contains(server.getServerId())).collect(Collectors.toList());
		
		}
		
		model.addAttribute("selectedServers",selectedServers);
		
 
		
		return "selectedservers";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/calculatePrice", method = RequestMethod.POST)
	public Server calculatePrice(@RequestBody List<Server> servers,ModelMap model) {
		Server serverOut = new Server();
		String formattedPrice;
		
		if(servers!=null && !servers.isEmpty()) {
		    
			int totalPrice = servers.stream().mapToInt(server->server.getServerPrice().intValue() * server.getQuantity()).sum();
		    
		    BigDecimal total = new BigDecimal(totalPrice);
		    java.util.Currency cad = java.util.Currency.getInstance("CAD");
			java.text.NumberFormat format = java.text.NumberFormat.getCurrencyInstance(java.util.Locale.CANADA);
			format.setCurrency(cad);
			serverOut.setFormattedPrice(format.format(total));
	   }
	   
	   return serverOut;
	
	}
	

}