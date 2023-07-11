package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.ProductModel;

/**
 * OrdersRestService allows the return of JSON and XML formatted Products list
 * @author Chael
 */
@RestController
@RequestMapping("/service")
public class ProductsRestService {
	
	//initialize service variable
	@Autowired
	private ProductsBusinessServiceInterface service;
	
	/**
	 * Returns JSON version of Products
	 * @return service.getProducts()
	 */
	@GetMapping(path="/products", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getProducts()
	{
		try {
			List<ProductModel> products = service.getProducts();
			if (products == null) 
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			else
				return new ResponseEntity<>(products, HttpStatus.OK);
		//returns all products in a json format
		//return service.getProducts();
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
	/**
	 * Returns JSON version of Products
	 * @return service.getProducts()
	 */
	@GetMapping(path="/product", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getProduct(long id)
	{
		try {
			ProductModel product = service.getProduct(id);
			if (product == null) 
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			else
				return new ResponseEntity<>(product, HttpStatus.OK);
		//returns one product in a json format
		//return service.getProduct();
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
}
