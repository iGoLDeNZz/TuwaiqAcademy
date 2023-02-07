package com.example.onetoone.Controller;

import com.example.onetoone.DTO.CustomerDetailsDTO;
import com.example.onetoone.Service.CustomerDetailsService;
import com.example.onetoone.Service.CustomerService;
import com.example.onetoone.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private CustomerService customerService;
    private CustomerDetailsService customerDetailsService;

    public CustomerController(CustomerService customerService,
                              CustomerDetailsService customerDetailsService){
        this.customerService = customerService;
        this.customerDetailsService = customerDetailsService;
    }

    @GetMapping("/get")
    public ResponseEntity getCustomer(){
        return ResponseEntity.status(200).body(customerService.getCustomers());
    }

    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
        return ResponseEntity.status(200).body("Customer was added.");
    }


    @GetMapping("/details/get")
    public ResponseEntity getCustomerDetails(){
        return ResponseEntity.status(200).body(customerDetailsService.getCustomerDetails());
    }

    @PostMapping("/details/add")
    public ResponseEntity addCustomerDetails(@RequestBody CustomerDetailsDTO customerDetailsDTO){
        customerDetailsService.addCustomerDetails(customerDetailsDTO);
        return ResponseEntity.status(200).body("Customer Details was added.");
    }
}
