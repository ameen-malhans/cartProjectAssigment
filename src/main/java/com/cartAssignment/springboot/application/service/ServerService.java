package com.cartAssignment.springboot.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cartAssignment.springboot.application.model.Server;


public interface ServerService {
	public List<Server> getAllServers();

}
