package com.market.product.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{
	public List<ProductEntity> getProductDetailsByName(String name);
}
