package com.cartAssignment.springboot.application.configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.cartAssignment.springboot.application.model.Server;
import com.cartAssignment.springboot.application.service.ServerService;
import com.cartAssignment.springboot.application.service.impl.ServerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment= WebEnvironment.NONE)
public class ServerServiceUnitTest {
	
	@Spy
	@InjectMocks
	private ServerService serverService = new ServerServiceImpl();
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testgetAllServers() {
		Server server = new Server();
		server.setServerId(1);
		server.setServerName("Test");
		server.setServerPrice(new BigDecimal(1000));
		server.setFormattedPrice("$1000");
		server.setQuantity(1);
		
		List<Server> list = new ArrayList<Server>();  
		list.add(server);

		Mockito.when(serverService.getAllServers()).thenReturn(list);
	
		List<Server>returnList = serverService.getAllServers();
		assertEquals(1, returnList.size());
		assertNotNull(returnList);
		
		
	}

}
