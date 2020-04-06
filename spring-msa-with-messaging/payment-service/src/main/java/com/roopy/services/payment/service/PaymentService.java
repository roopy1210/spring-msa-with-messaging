package com.roopy.services.payment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.roopy.services.payment.domain.Order;

@Service
public class PaymentService {

private static final Logger LOGGER = LoggerFactory.getLogger(PaymentService.class);
	
	private ObjectMapper mapper = new ObjectMapper();
	
	public void process(final Order order) throws JsonProcessingException {
		LOGGER.info("Order processed: {}", mapper.writeValueAsString(order));
	}
	
}
