package com.market.product.controller;
//Server Post 8082
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.market.product.entity.ProductEntity;
import com.market.product.service.ProductService;

@RestController
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	ProductService service;
	String response;
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody ProductEntity entity) {
		service.addProduct(entity);
		response = "Product added successfully";
		logger.info(response);
		return response;
	}
	
	@GetMapping("/getProductDetails")
	public List<ProductEntity> getProductDetails(){
		return service.getProductDetails();
	}
	
	@GetMapping("/getProductDetailsById")
	public Optional<ProductEntity> getProductDetailsById(@RequestParam int id){
		return service.getProductDetailsById(id);
	}
	
	@GetMapping("/getProductDetailsByName")
	public List<ProductEntity> getProductDetailsByName(@RequestParam String name){
		return service.getProductDetailsByName(name);
	}
	
	@PutMapping("/updateProduct")
	public String updateProduct(@RequestBody ProductEntity entity) {
		service.updateProduct(entity);
		response = "Update successfull";
		logger.info(response);
		return response;
	}
	
	@DeleteMapping("/deleteProductById")
	public String deleteProductById(@RequestParam int id) {
		service.deleteProductById(id);
		response = "Product deleted successfully";
		logger.info(response);
		return response;
	}
}
