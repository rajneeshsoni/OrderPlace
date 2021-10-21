package com.order.orderplace.api.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.order.orderplace.api.model.EcomOrder;
import com.order.orderplace.api.model.ProductCartLog;
import com.order.orderplace.api.model.ProductOrder;
import com.order.orderplace.api.repository.OrderRepo;


@Service
public class OrderingService {
	
	private static Logger log = LoggerFactory.getLogger(OrderingService.class);
	@Autowired
	private EurekaClient eurekaClient;

	@Autowired
	private OrderRepo orderRepo;
	
	 public Integer placeOrder(ProductCartLog orderdetails, String auth) { 
		/*
		 * InstanceInfo info = eurekaClient.getNextServerFromEureka("PRODUCTCART",
		 * false); String url = "http://" + info.getHostName() + ":" + info.getPort() +
		 * "/product/getCartData/{id}"; ResponseEntity<ProductOrder[]> response = new
		 * RestTemplate().getForEntity(url, ProductOrder[].class, auth);
		 * log.info("	"+url);
		 */
			EcomOrder order = new EcomOrder();
			List<ProductOrder> prodList = new ArrayList<ProductOrder>();   ;
			if(orderdetails != null)
			{
				for (int i=0;i<orderdetails.getListOfProduct().size();i++)
				{
					ProductOrder orderP= new ProductOrder();
					orderP.setProductAmount(orderdetails.getListOfProduct().get(i).getProductAmount());
					orderP.setProductId(orderdetails.getListOfProduct().get(i).getProductId());
					orderP.setProductName(orderdetails.getListOfProduct().get(i).getProductName());
					orderP.setProductUnit(orderdetails.getListOfProduct().get(i).getProductUnit());
					orderP.setUsername(orderdetails.getListOfProduct().get(i).getUsername());
					prodList.add(orderP);
				}
			}
			
			order.setProductList(prodList); 
			order = orderRepo.save(order);
		/*
		 * if(order.getId() !=0) { removeCartOrder(auth); }
		 */
			return order.getId();
	 }
	 
	 public void removeCartOrder(String auth) { 
		 InstanceInfo info = eurekaClient.getNextServerFromEureka("PRODUCTCART", false);
			String url = "http://" + info.getHostName() + ":" + info.getPort() + "/product/deleteCart/{userName}";
			//ResponseEntity<String> response = new RestTemplate().delete(url,  auth);
			RestTemplate restTemplate = new RestTemplate();
			 restTemplate.delete(url,  auth);
		 
	 }
	 
	 public Optional<EcomOrder> getOrderDetails(Integer id) {
			return orderRepo.findById(id);
		}

}
