package com.example.week5_project.Controller;

import com.example.week5_project.Service.CustomerService;
import com.example.week5_project.model.Customer;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/get")
    public ResponseEntity getCustomer(){
        return ResponseEntity.status(200).body(customerService.getAllCustomers());
    }

    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
        return ResponseEntity.status(200).body("Customer was added.");
    }

    @PutMapping("/update/{customerId}")
    public ResponseEntity updateCustomer(@RequestBody @Valid Customer customer, @PathVariable Integer customerId){
        customerService.updateCustomer(customerId,customer);
        return ResponseEntity.status(200).body("Customer updates");
    }

    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity deleteCustomer(@PathVariable Integer customerId){
        customerService.deleteCustomer(customerId);
        return ResponseEntity.status(200).body("Customer deleted");
    }
}
