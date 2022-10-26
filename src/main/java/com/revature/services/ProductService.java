package com.revature.services;

import com.revature.dtos.ProductInfo;
import com.revature.models.Product;
import com.revature.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * This method is used to get all  products from database
     * @return List<Product>> This returns  list of Product object.
     */
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    /**
     * This method is used to get all  products from database by product_id
     * @param id This is the  parameter of findById method
     * @return Optional<Product> This returns  not-null Product objects.
     */
    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }

    /**
     * This method is used to save Product object in database
     * @param product This is the  parameter of Save method
     * @return product This returns Product object.
     */
    public Product save(Product product) {
        return productRepository.save(product);
    }

    /**
     * This method is used to save Product objects in database
     * @param productList This is the first parameter to saveAll method
     * @param metadata This is the second parameter to saveAll method
     * @return List<Product> This returns  List of Product objects.
     */
    public List<Product> saveAll(List<Product> productList, List<ProductInfo> metadata) {
    	return productRepository.saveAll(productList);
    }

    /**
     * This method is used to delete  Product object from  database by product_id
     * @param id This is the  parameter of delete method
     * @return Nothing.
     */
    public void delete(int id) {
        productRepository.deleteById(id);
    }
}
