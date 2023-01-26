package com.example.week_3_project.service;

import com.example.week_3_project.model.MerchantStock;
import com.example.week_3_project.model.Product;
import com.example.week_3_project.model.User;
import com.example.week_3_project.utility.ServiceResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    ArrayList<User> users = new ArrayList<>();

   MerchantStockService merchantStockService;
   ProductService productService;

    public UserService(MerchantStockService merchantStockService, ProductService productService){
        this.merchantStockService = merchantStockService;
        this.productService = productService;
    }


    public ArrayList<User> getAllUsers(){
        return users;
    }

    public void addUser(User user){
        users.add(user);
    }

    public ServiceResponse updateUser(User user, int id){
        for (int i = 0; i < users.size(); i++)
            if(users.get(i).getId().equals(id)) {
                users.set(i, user);
                return new ServiceResponse(200, "user with id: "+id+" was updated.");
            }
        return new ServiceResponse(404, "user with id: "+id+" not found.");
    }

    public ServiceResponse deleteUser(int id){
        for (int i = 0; i < users.size(); i++)
            if(users.get(i).getId().equals(id)) {
                users.remove(i);
                return new ServiceResponse(200, "user with id: "+id+" was deleted.");
            }
        return new ServiceResponse(400, "user with id: "+id+" not found.");
    }

//    Create endpoint where user can add product to a merchantStock
//this endpoint should accept a productid and merchantid and stock

    public ServiceResponse addStock(String productId, String merchantId, int stock){

        if(stock < 1 ){
            return new ServiceResponse(400, "Stock must be positive");
        }

        for (int i = 0; i < merchantStockService.merchantStocks.size(); i++) {
            if (merchantStockService.merchantStocks.get(i).getProductId().equals(productId)
                && merchantStockService.merchantStocks.get(i).getMerchantId().equals(merchantId)){

                int currentStock = merchantStockService.merchantStocks.get(i).getStock();
                merchantStockService.merchantStocks.get(i).setStock(currentStock+stock);

                return new ServiceResponse(200, "Stock was added.");
            }
        }
        return new ServiceResponse(400, "product from merchant was not found");
    }

    //Old solution if there was a relationship between tables
//    public ServiceResponse addStock(String productId, String merchantId, int stock){
//        boolean productExists = false;
//        boolean merchantExists = false;
//        for (int i = 0; i < productService.products.size(); i++) {
//            if (productService.products.get(i).getId().equals(productId)){
//                productExists = true;
//                break;
//            }
//        }
//        for (int i = 0; i < merchantService.merchants.size(); i++) {
//            if (merchantService.merchants.get(i).getId().equals(merchantId)){
//                merchantExists = true;
//                break;
//            }
//        }
//        if (merchantExists && productExists ){
//            // do logic
//        }
//    }

//    Create endpoint where user can buy a product directly
//this endpoint should accept userid , product id , merchantId.
//            check if all the given id is valid or not
//    check if the merchant have the product in stock or return bad request.
//    reduce the stock from the MerchantStock.
//    deducted the price of the product from the user balance.
//            if balance is less than the product price return bad request.

    public ServiceResponse buy(String userid, String productId, String merchantId, int quantitiy){

        User buyer = null;
        boolean productExists = false;
        boolean hasBalance = false;
        double totalCost = 0;

        // 1. check quantity is positive

        if(quantitiy < 1 ){
            return new ServiceResponse(400, "Stock to buy must be positive");
        }

        // 2. a) Check product exists then calculate order cost:

        for (Product product : productService.products){
            if (product.getId().equals(productId)){
                totalCost = product.getPrice() * quantitiy;
                productExists = true;
            }
        }

        // 2. b) return bad request if product does not exist
        if (!productExists)
            return new ServiceResponse(400, "product with id: "+productId+" from merchant with id: "+merchantId+" was not found");


        // 3. a) Check user balance
        for (User user: users){
            if( user.getId().equals(userid)){
                buyer = user;
                if (user.getBalance() >= totalCost)
                    hasBalance = true;
            }
        }

        // 3. b) return bad request if user balance less than total cost
        if (!hasBalance)
            return new ServiceResponse(400, "Insufficient balance");


        // 4. a) check if a product and merchant exist and stock is enough
        for (int i = 0; i < merchantStockService.merchantStocks.size(); i++) {
            if (merchantStockService.merchantStocks.get(i).getProductId().equals(productId)
                    && merchantStockService.merchantStocks.get(i).getMerchantId().equals(merchantId)){

                int currentStock = merchantStockService.merchantStocks.get(i).getStock();

                if (currentStock >= quantitiy) {
                    // 4 b) deduct cost from user balance
                    // 4 c) reduce stock by quantity ordered

                    merchantStockService.merchantStocks.get(i).setStock(currentStock - quantitiy);
                    buyer.setBalance(buyer.getBalance() - totalCost);
                    return new ServiceResponse(200, "Order was fulfilled.");
                } else {
                    return new ServiceResponse(400, "Not enough stock for the order. Current stock: "+currentStock+". Order quantity: "+quantitiy+".");
                }
            }
        }
        return new ServiceResponse(400, "product with id: "+productId+" from merchant with id: "+merchantId+" was not found");



    }



}
