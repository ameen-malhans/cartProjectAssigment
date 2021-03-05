package com.cartAssignment.springboot.application.model;

import java.math.BigDecimal;

public class Server {
	
	private Integer serverId;
	
	private String serverName;
	
	private BigDecimal serverPrice;
	
	private Integer quantity;

	private String formattedPrice;


	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getServerId() {
		return serverId;
	}

	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}





	public String getFormattedPrice() {
		return formattedPrice;
	}

	public void setFormattedPrice(String formattedPrice) {
		this.formattedPrice = formattedPrice;
	}



	public BigDecimal getServerPrice() {
		return serverPrice;
	}

	public void setServerPrice(BigDecimal serverPrice) {
		this.serverPrice = serverPrice;
	}

	@Override
	public String toString() {
		return "Server [serverId=" + serverId + ", serverName=" + serverName + ", serverPrice=" + serverPrice + "]";
	}

	
	
	

}
