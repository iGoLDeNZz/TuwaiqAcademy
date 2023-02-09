package com.example.week5_project.Controller;

import com.example.week5_project.Service.StoreService;
import com.example.week5_project.model.Store;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/store")
public class StoreController {

    private StoreService storeService;

    public StoreController(StoreService storeService){
        this.storeService = storeService;
    }

    @GetMapping("/get")
    public ResponseEntity getStore(){
        return ResponseEntity.status(200).body(storeService.getAllStores());
    }

    @PostMapping("/add")
    public ResponseEntity addStore(@RequestBody Store store){
        storeService.addStore(store);
        return ResponseEntity.status(200).body("Store was added.");
    }

    @PutMapping("/update/{storeId}")
    public ResponseEntity updateStore(@RequestBody @Valid Store store, @PathVariable Integer storeId){
        storeService.updateStore(storeId,store);
        return ResponseEntity.status(200).body("Store updates");
    }

    @DeleteMapping("/delete/{storeId}")
    public ResponseEntity deleteStore(@PathVariable Integer storeId){
        storeService.deleteStore(storeId);
        return ResponseEntity.status(200).body("Store deleted");
    }

    @GetMapping("/{storeId}/books")
    public ResponseEntity getAllBooksForStore(@PathVariable Integer storeId){
        return ResponseEntity.status(200).body(storeService.getAllBooksForStore(storeId));
    }

    @GetMapping("/{storeId}/customers")
    public ResponseEntity getAllCustomersForStore(@PathVariable Integer storeId){
        return ResponseEntity.status(200).body(storeService.getAllCustomersForStore(storeId));
    }

    @PutMapping("/add/{storeId}/customer/{customerId}")
    public ResponseEntity addCustomerToAStore(@PathVariable Integer storeId, @PathVariable Integer customerId){
        storeService.addCustomerToAStore(storeId,customerId);
        return ResponseEntity.status(200).body("Customer was added to the store");
    }
}
