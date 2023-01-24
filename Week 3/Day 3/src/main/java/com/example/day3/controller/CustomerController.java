package com.example.day3.controller;

import com.example.day3.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/api/v1/bank/customers")
public class CustomerController {

    ArrayList<Customer> customers = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Customer> getCustomers(){
        return customers;
    }

    @PostMapping("/add")
    public String addCustomer(@RequestBody Customer customer){
        customers.add(customer);

        return "Customer Added";
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestParam String id, @RequestBody Customer customer){
        for (Customer currentCustomer : customers) {
            if(currentCustomer.getId().equals(id)){
                currentCustomer.setId(customer.getId());
                currentCustomer.setUsername(customer.getUsername());
                currentCustomer.setBalance(customer.getBalance());
                return "Customer with id: "+id+" was updated";
            }
        }
        return "Customer with id: "+id+" was not found.";
    }


    @DeleteMapping("/delete")
    public String deleteCustomer(@RequestParam String id){

        int index = 0;
        for (Customer currentCustomer : customers) {
            if (currentCustomer.getId().equals(id)) {
                customers.remove(index);
                return "Customer with id: "+id+" was deleted";
            }
            index++;
        }
        return "Customer with id: "+id+" was not found.";
    }

    @PutMapping("/deposit")
    public String deposit(@RequestParam double amount, @RequestParam String id){
        for (int i = 0; i < customers.size(); i++) {
            Customer currentCustomer = customers.get(i);
            if(currentCustomer.getId().equals(id)){
                currentCustomer.setBalance(currentCustomer.getBalance()+amount);
                return amount+"SR was added to your balance";
            }
        }
        return "Customer with id: "+id+" was not found.";
    }

    @PutMapping("/withdraw")
    public String withdraw(@RequestParam double amount, @RequestParam String id){
        for (int i = 0; i < customers.size(); i++) {
            Customer currentCustomer = customers.get(i);
            if(currentCustomer.getId().equals(id)){
                if(currentCustomer.getBalance() >= amount){
                    currentCustomer.setBalance(currentCustomer.getBalance()-amount);
                    return "Your new balance is: " + currentCustomer.getBalance()+"SR.";
                }
                return "Insufficient fund.";
            }
        }
        return "Customer with id: "+id+" was not found.";
    }
}
