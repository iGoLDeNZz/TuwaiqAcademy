package com.example.onetoone.Repository;

import com.example.onetoone.model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Integer> {
}
