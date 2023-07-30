package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.business.ProductsBusinessService;
import com.gcu.business.ProductsBusinessServiceInterface;
import com.gcu.business.OrdersBusinessService;

/**
 * SpringConfig configures the Spring Bean to generate a new OrdersBusinessService
 * @author Chael
 */
@Configuration
public class SpringConfig {
	
	/**
	 * creates a Spring Bean as an instance of the class OrdersBusinessService
	 * @return OrdersBusinessService
	 */
	@Bean(name="ordersBusinessService", initMethod="init", destroyMethod="destroy")
	public OrdersBusinessServiceInterface getOrdersBusiness() 
	{
		//returns a new instance of OrdersBusinessService to be used
		return new OrdersBusinessService();
	}
	
	/**
	 * creates a Spring Bean as an instance of the class ProductsBusinessService
	 * @return ProductsBusinessService
	 */
	@Bean(name="productsBusinessService", initMethod="init", destroyMethod="destroy")
	public ProductsBusinessServiceInterface getProductsBusiness() 
	{
		//returns a new instance of ProductsBusinessService to be used
		return new ProductsBusinessService();
	}
}