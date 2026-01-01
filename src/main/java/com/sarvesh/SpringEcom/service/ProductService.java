package com.sarvesh.SpringEcom.service;

import com.sarvesh.SpringEcom.model.Product;
import com.sarvesh.SpringEcom.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    public ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(null );
    }

    public Product addProduct(Product product, MultipartFile image) throws IOException {
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());
        return  productRepo.save(product);
    }

    public Product updateProduct(int id, Product product, MultipartFile image) {
        Optional<Product> existingProductOpt = productRepo.findById(id);
        if(existingProductOpt.isEmpty()){
            return null;
        }

        Product existingProduct = existingProductOpt.get();

        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setBrand(product.getBrand());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setReleaseDate(product.getReleaseDate());
        existingProduct.setProductAvailable(product.getProductAvailable());
        existingProduct.setStockQuantity(product.getStockQuantity());
        if(image!=null && !image.isEmpty()) {
            existingProduct.setImageName(product.getImageName());
            existingProduct.setImageType(product.getImageType());
            existingProduct.setImageData(product.getImageData());
        }
        return productRepo.save(existingProduct);


    }

    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return productRepo.searchProducts(keyword);
    }
}
