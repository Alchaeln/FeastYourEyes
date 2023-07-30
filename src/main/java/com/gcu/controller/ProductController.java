package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.business.ProductsBusinessServiceInterface;
import com.gcu.data.DataAccessInterface;
import com.gcu.model.ProductModel;

/**
 * Has all the routes for the product page
 * 
 * @author Chael
 */
@Controller
//Sets up URI for localhost:8080/login
@RequestMapping("/")
public class ProductController {

	@Autowired
	private ProductsBusinessServiceInterface service;
	@Autowired
	private DataAccessInterface<ProductModel> dataService;

	/**
	 * basic product page
	 * 
	 * @param model
	 * @return newProduct view
	 */
	@GetMapping("/favorites")
	public String display(Model model) {
		try {
			model.addAttribute("title", "F A V O R I T E S");
			model.addAttribute("productModel", service.getProducts());
			model.addAttribute("productID", new ProductModel());
			// change back when done testing
			return "products";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("title", "Error Page");
			model.addAttribute("message", "ERROR: You have now entered the error page");
			return "errors";
		}
	}

	/**
	 * Specific product page
	 * @param model
	 * @return newProduct view
	 */
	@PostMapping("/favorite")
	public String displayProduct(ProductModel product, Model model) {
		System.out.println(product.getId());
		try {
			model.addAttribute("title", service.getProduct(product.getId()).getProductName());
			model.addAttribute("productModel", service.getProduct(product.getId()));
			return "favorite";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("title", "Error Page");
			model.addAttribute("message", "ERROR: You have now entered the error page");
			return "errors";
		}
	}

	/**
	 * Method for displaying add product page
	 * 
	 * @param model
	 * @return Product view
	 */
	// Sets up URI for localhost:8080/enterProduct/
	@GetMapping("/enterProduct")
	public String enterProduct(Model model) {
		// adds attributes of title and productModel to be shown in the web page
		model.addAttribute("title", "Add a Product");
		model.addAttribute("productModel", new ProductModel());
		return "newProduct";
	}

	/**
	 * validates and adds product
	 * 
	 * @param productModel
	 * @param bindingResult
	 * @param model
	 * @return newProduct view
	 */
	@PostMapping("/addProduct")
	// @Valid checks that the product model is valid
	public String addProduct(@ModelAttribute @Valid ProductModel productModel,
            @RequestParam("selectedPhotoUrl") String selectedPhotoUrl,
            BindingResult bindingResult, Model model) {
		// if product is invalid, send back to product page
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Did not add product!");
			model.addAttribute("productModel", new ProductModel());
			return "products";
		}
		try {
			//String photoUrl = "/images/food/Subway-sandwich.jpg";

			// Check if the photo name is the desired one
			//String photoName = photoUrl.substring(photoUrl.lastIndexOf("/") + 1);
			System.out.println(productModel.getPhotoUrl());
	        // Set the photo URL in the productModel object
	        productModel.setPhotoUrl(selectedPhotoUrl);

	        String photoName = productModel.getPhotoUrl().substring(productModel.getPhotoUrl().lastIndexOf("/") + 1);
	        if (photoName.equals("Subway-sandwich.jpg")) {
	            productModel.setProductName("Subway");
	            productModel.setPrice("Yes");
	            productModel.setQuantity("3.8");
	        } else if (photoName.equals("KrispyKreme.jpg")) {
	            productModel.setProductName("Krispy Kreme");
	            productModel.setPrice("Yes");
	            productModel.setQuantity("4");
	        }
	        else if (photoName.equals("ElCarbonero.jpg")) {
		            productModel.setProductName("El Carbonero");
		            productModel.setPrice("Yes");
		            productModel.setQuantity("4");
	        } 
	        else if (photoName.equals("GreatWall.jpg")) {
		            productModel.setProductName("Great Wall Cuisine");
		            productModel.setPrice("Yes");
		            productModel.setQuantity("4.2");   
	        }
	        else if (photoName.equals("Einstein.jpg")) {
	            productModel.setProductName("Einstein Bros Bagels");
	            productModel.setPrice("Yes");
	            productModel.setQuantity("3.8");
	        } 
	        else if (photoName.equals("LittleCaesarsPizza.jpg")) {
	            productModel.setProductName("Little Caesars Pizza");
	            productModel.setPrice("Yes");
	            productModel.setQuantity("3.6");
	            
	        }
	        else if (photoName.equals("McDonalds.jpg")) {
	            productModel.setProductName("McDonalds");
	            productModel.setPrice("Yes");
	            productModel.setQuantity("3.4");
	            
	        }
	        else if (photoName.equals("QT.jpg")) {
	            productModel.setProductName("QuikTrip ");
	            productModel.setPrice("Yes");
	            productModel.setQuantity("3.5"); 
	        }
	        else if (photoName.equals("Starbucks.jpg")) {
	            productModel.setProductName("Starbucks");
	            productModel.setPrice("Yes");
	            productModel.setQuantity("4");
	        }
		   else {
	            // Handle the case when the photo name does not match any desired product
	            System.out.println("Unknown product photo: " + photoName);
	            return "products";
	        }

			dataService.create(productModel);

			model.addAttribute("title", "Added Favorite!");
			model.addAttribute("productModel", service.getProducts());

			return "products";
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("title", "Error Page");
			// passes order list that was just made to orders page
			model.addAttribute("message", "ERROR: You have now entered the error page");
			return "errors";
		}
	}

	/**
	 * Method for displaying update product page
	 * 
	 * @param model
	 * @return Product view
	 */
	// Sets up URI for localhost:8080/enterProduct/
	@PostMapping("/updateFavorite")
	public String updateProduct(ProductModel productModel, Model model) {
		// adds attributes of title and productModel to be shown in the web page
		model.addAttribute("title", "Update " + service.getProduct(productModel.getId()).getProductName());
		model.addAttribute("productModel", service.getProduct(productModel.getId()));
		return "updateProduct";
	}

	/**
	 * validates and updates product
	 * 
	 * @param productModel
	 * @param bindingResult
	 * @param model
	 * @return newProduct view
	 */
	@PostMapping("/doUpdateFavorite")
	// @Valid checks that the product model is valid
	public String doUpdateProduct(@Valid ProductModel productModel, BindingResult bindingResult, Model model) {
		// if product is invalid, send back to product page
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Did not update product!");
			model.addAttribute("productModel", productModel);
			return "updateProduct";
		}
		try {
			System.out.println(productModel.getId() + " " + productModel.getProductName());
			dataService.update(productModel);

			model.addAttribute("title", "Updated Product!");
			model.addAttribute("productModel", service.getProducts());

			return "products";
		} catch (Exception e) {
			model.addAttribute("title", "Error Page");
			// passes order list that was just made to orders page
			model.addAttribute("message", "ERROR: You have now entered the error page");
			return "errors";
		}
	}

	/**
	 * Method for displaying delete product page
	 * 
	 * @param model
	 * @return Product view
	 */
	// Sets up URI for localhost:8080/enterProduct/
	@PostMapping("/deleteFavorite")
	public String deleteProduct(ProductModel product, Model model) {
		// adds attributes of title and productModel to be shown in the web page
		model.addAttribute("title", "Delete a Favorite");
		model.addAttribute("productModel", service.getProduct(product.getId()));
		return "deleteProduct";
	}

	/**
	 * validates and deletes product
	 * 
	 * @param productModel
	 * @param bindingResult
	 * @param model
	 * @return newProduct view
	 */
	@PostMapping("/doDeleteProduct")
	// @Valid checks that the product model is valid
	public String doDeleteProduct(Model model, ProductModel product) {
		try {
			dataService.delete(product);

			model.addAttribute("title", "Deleted Product!");
			model.addAttribute("productModel", service.getProducts());

			return "products";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("title", "Error Page");
			// passes order list that was just made to orders page
			model.addAttribute("message", "ERROR: You have now entered the error page");
			return "errors";
		}
	}
}
