package com.market.product.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.product.entity.ProductEntity;
import com.market.product.entity.ProductRepository;

@Service
public class ProductService {
	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
	@Autowired
	ProductRepository repository;
	String response;

	public String addProduct(ProductEntity entity) {
		// TODO Auto-generated method stub
		System.out.println(entity.toString());
		logger.info(entity.toString());
		repository.save(entity);
		response = "Product added successfully";
		logger.info(response);
		return response;
	}

	public List<ProductEntity> getProductDetails() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public String updateProduct(ProductEntity entity) {
		// TODO Auto-generated method stub
		System.out.println(entity.toString());
		logger.info(entity.toString());
		repository.save(entity);
		response = "Update successful";
		logger.info(response);
		return response;
				
	}

	public String deleteProductById(int id) {
		// TODO Auto-generated method stub
		try {
			repository.deleteById(id);
			response = "deleted successfully";
			logger.info(response);
		} catch (Exception e) {
			// TODO: handle exception
			response = "Invalid ID: "+id;
		}
		return response;
	}

	public Optional<ProductEntity> getProductDetailsById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	public List<ProductEntity> getProductDetailsByName(String name) {
		// TODO Auto-generated method stub
		return repository.getProductDetailsByName(name);
	}

}
