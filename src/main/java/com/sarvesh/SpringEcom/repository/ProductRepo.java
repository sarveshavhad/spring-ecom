package com.sarvesh.SpringEcom.repository;

import com.sarvesh.SpringEcom.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
