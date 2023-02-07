package com.example.onetoone.Service;

import com.example.onetoone.Repository.CustomerRepository;
import com.example.onetoone.model.Customer;
import com.example.onetoone.model.CustomerDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Integer id){
        return customerRepository.findCustomerById(id);
    }

}
