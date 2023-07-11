package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.OrderList;
import com.gcu.model.OrderModel;
import com.gcu.model.ProductModel;

/**
 * OrdersRestService allows the return of JSON and XML formatted orders list
 * @author Chael
 */
@RestController
@RequestMapping("/service")
public class OrdersRestService {
	
	//initialize service variable
	@Autowired
	private OrdersBusinessServiceInterface service;
	
	/**
	 * Returns JSON version of orders
	 * @return service.getOrders()
	 */
	@GetMapping(path="/getjson", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getOrdersAsJson()
	{
		try {
			List<OrderModel> orders = service.getOrders();
			if (orders == null) 
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			else
				return new ResponseEntity<>(orders, HttpStatus.OK);
		//returns all products in a json format
		//return service.getProducts();
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Returns XML format list of orders
	 * @return return list
	 */
	@GetMapping(path="/getxml", produces= {MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getOrdersAsXml()
	{
		OrderList list = new OrderList();
		
		try {
			list.setOrders(service.getOrders());
			if (list == null) 
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			else
				return new ResponseEntity<>(list, HttpStatus.OK);
		//returns all products in a json format
		//return service.getProducts();
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//OrderList list = new OrderList();
		//uses the getOrders method from OrderList to transfer the data into the order list
		//list.setOrders(service.getOrders());
		//return list;
	}
}
