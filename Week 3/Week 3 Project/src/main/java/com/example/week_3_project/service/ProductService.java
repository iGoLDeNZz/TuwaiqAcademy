package com.example.week_3_project.service;

import com.example.week_3_project.model.Merchant;
import com.example.week_3_project.model.Product;
import com.example.week_3_project.utility.ServiceResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {

    ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getAllProducts(){
        return products;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public ServiceResponse updateProduct(Product product, String id){
        for (int i = 0; i < products.size(); i++)
            if(products.get(i).getId().equals(id)) {
                products.set(i, product);
                return new ServiceResponse(200, "product with id: "+id+" was updated.");
            }
        return new ServiceResponse(404, "product with id: "+id+" not found.");
    }

    public ServiceResponse deleteProduct(String id){
        for (int i = 0; i < products.size(); i++)
            if(products.get(i).getId().equals(id)) {
                products.remove(i);
                return new ServiceResponse(200, "product with id: "+id+" was deleted.");
            }
        return new ServiceResponse(400, "product with id: "+id+" not found.");
    }
}
