package com.example.week6_day2_security.service;

import com.example.week6_day2_security.Exception.APIException;
import com.example.week6_day2_security.model.Product;
import com.example.week6_day2_security.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Integer id){
        Product product = productRepository.findProductById(id);
        if (product == null)
            throw new APIException("ID not found", 404);
        return product;
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public void updateProduct(Integer id, Product product){
        Product oldProduct = getProductById(id);

        product.setId(oldProduct.getId());
        productRepository.save(product);
    }

    public void deleteProduct(Integer id){
        Product product = getProductById(id);
        productRepository.delete(product);
    }

    public Product findProductByName(String name){
        Product product = productRepository.findProductByName(name);
        if (product == null)
            throw new APIException("Product with name: "+name+" not found", 404);

        return product;
    }


}
