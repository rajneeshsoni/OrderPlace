package com.order.orderplace.api.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.order.orderplace.api.model.EcomOrder;
import com.order.orderplace.api.model.ProductCartLog;
import com.order.orderplace.api.services.OrderingService;
import com.order.orderplace.api.util.ApiException;
import com.order.orderplace.api.util.JwtUtil;


@RestController
@RequestMapping(path="/orderPlace") 
public class OrderPlaceController {
	
	private static Logger log = LoggerFactory.getLogger(OrderPlaceController.class);
	
	/*
	 * @Autowired ProductRepository prodRep;
	 */
	
	@Autowired 
	JwtUtil jwtUtils;
	
	
	
	
	@Autowired
	OrderingService orderingService;
	
	@RequestMapping( method = RequestMethod.POST)
	public Integer addProductCart(@RequestBody ProductCartLog logs ,HttpServletRequest request) throws ClassNotFoundException, ApiException
	{
		log.info("addProductCart ::::"+jwtUtils.getUsername(request));
		int orderNum= orderingService.placeOrder(logs,jwtUtils.getUsername(request));
		
		 // if(orderNum !=0) {
		 // orderingService.removeCartOrder(jwtUtils.getUsername(request)); }
		 
		return orderNum;
		//return 0;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EcomOrder> getOrderDetails(@PathVariable Integer id) {
	
		
		Optional<EcomOrder> o = orderingService.getOrderDetails(id);
		if(o.isPresent()) {
			return new ResponseEntity<EcomOrder>(o.get(), HttpStatus.OK);
		}else
			return new ResponseEntity(HttpStatus.NOT_FOUND);

	}

}
