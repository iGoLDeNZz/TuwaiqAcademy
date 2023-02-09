package com.example.week5_project.Service;

import com.example.week5_project.Repository.CustomerRepository;
import com.example.week5_project.Utility.APIException;
import com.example.week5_project.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomerBy(Integer customerId){
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer == null)
            throw new APIException("Customer not found", 404);
        return customer;
    }

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void updateCustomer(Integer customerId, Customer customer){
        Customer storedCustomer = getCustomerBy(customerId);

        storedCustomer.setName(customer.getName());
        customerRepository.save(storedCustomer);
    }

    public void deleteCustomer(Integer customerId){
        getCustomerBy(customerId);
        customerRepository.deleteById(customerId);
    }
}
