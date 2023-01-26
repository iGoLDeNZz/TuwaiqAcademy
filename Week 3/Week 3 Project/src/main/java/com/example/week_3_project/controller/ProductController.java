package com.example.week_3_project.controller;

import com.example.week_3_project.model.Merchant;
import com.example.week_3_project.model.Product;
import com.example.week_3_project.service.ProductService;
import com.example.week_3_project.utility.ServiceResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }


    @GetMapping("/get")
    public ResponseEntity getAllProducts(){
        return ResponseEntity.status(200).body(productService.getAllProducts());
    }

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody @Valid Product product, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        productService.addProduct(product);
        return ResponseEntity.status(200).body("Product: "+product.getName()+" was added.");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@RequestBody @Valid Product product, @PathVariable String id, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        ServiceResponse result = productService.updateProduct(product, id);
        return ResponseEntity.status(result.getStatus()).body(result.getMessage());
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id){
        ServiceResponse result = productService.deleteProduct(id);

        return ResponseEntity.status(result.getStatus()).body(result.getMessage());
    }


}