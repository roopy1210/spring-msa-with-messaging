package com.roopy.services.order.controller;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.roopy.services.order.domain.Order;
import com.roopy.services.order.messaging.OrderSender;

@RestController
public class OrderController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	OrderSender sender;	
	
	@PostMapping
	public Order process(@RequestBody Order order) throws JsonProcessingException {
		boolean isSent = sender.send(order);
		LOGGER.info("Order sent: {}", mapper.writeValueAsString(Collections.singletonMap("isSent", isSent)));
		return order;
	}
	
}