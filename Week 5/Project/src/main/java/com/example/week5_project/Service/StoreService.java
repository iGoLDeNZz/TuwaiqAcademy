package com.example.week5_project.Service;

import com.example.week5_project.Repository.StoreRepository;
import com.example.week5_project.Utility.APIException;
import com.example.week5_project.model.Book;
import com.example.week5_project.model.Customer;
import com.example.week5_project.model.Store;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class StoreService {

    private StoreRepository storeRepository;
    private CustomerService customerService;

    public StoreService(StoreRepository storeRepository,
                        CustomerService customerService){
        this.storeRepository = storeRepository;
        this.customerService = customerService;
    }

    public List<Store> getAllStores(){
        return storeRepository.findAll();
    }

    public Store getStoreBy(Integer storeId){
         Store store = storeRepository.findById(storeId).orElse(null);
         if (store == null)
             throw new APIException("Store not found", 404);
         return store;
    }

    public void addStore(Store store){
        storeRepository.save(store);
    }

    public void updateStore(Integer storeId, Store store){
        Store storedStore = storeRepository.findById(storeId).orElse(null);

        if(storedStore == null)
            throw new APIException("Store not found", 404);

        storedStore.setName(store.getName());
        storeRepository.save(storedStore);
    }

    public void deleteStore(Integer storeId){
        Store store = storeRepository.findById(storeId).orElse(null);
        if(store == null)
            throw new APIException("Store not found", 404);

        storeRepository.deleteById(storeId);
    }

    public Set<Book> getAllBooksForStore(Integer storeId){
        Store store = getStoreBy(storeId);
        return store.getBooks();
    }

    public Set<Customer> getAllCustomersForStore(Integer storeId){
        Store store = getStoreBy(storeId);
        return store.getCustomers();
    }

    public void addCustomerToAStore(Integer storeId, Integer customerId){
        Store store = getStoreBy(storeId);
        Customer customer = customerService.getCustomerBy(customerId);

        store.getCustomers().add(customer);
        customer.getStores().add(store);
        addStore(store);
        customerService.addCustomer(customer);
    }
}
