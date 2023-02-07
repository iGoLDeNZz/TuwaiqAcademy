package com.example.onetoone.Service;

import com.example.onetoone.DTO.CustomerDetailsDTO;
import com.example.onetoone.Repository.CustomerDetailsRepository;
import com.example.onetoone.model.Customer;
import com.example.onetoone.model.CustomerDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDetailsService {


    private final CustomerService customerService;
    private final CustomerDetailsRepository customerDetailsRepository;

    public CustomerDetailsService(CustomerService customerService,
                                  CustomerDetailsRepository customerDetailsRepository){
        this.customerDetailsRepository = customerDetailsRepository;
        this.customerService = customerService;
    }

    public List<CustomerDetails> getCustomerDetails(){
        return customerDetailsRepository.findAll();
    }

    public void addCustomerDetails(CustomerDetailsDTO cdDTO){
        Customer customer = customerService.getCustomerById(cdDTO.getCustomerId());
        if(customer == null)
            throw new RuntimeException();

        CustomerDetails customerDetails = new CustomerDetails(null, cdDTO.getAge(), cdDTO.getPhoneNumber(), cdDTO.getGender(), customer);
        customerDetailsRepository.save(customerDetails);
    }
}
