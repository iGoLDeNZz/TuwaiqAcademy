package com.example.week6_day2_security.repository;

import com.example.week6_day2_security.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findProductById(Integer id);
    Product findProductByName(String name);
}
