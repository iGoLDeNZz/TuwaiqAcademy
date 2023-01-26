package com.example.week_3_project.service;

import com.example.week_3_project.model.Merchant;
import com.example.week_3_project.model.MerchantStock;
import com.example.week_3_project.utility.ServiceResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockService {

    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();

    public ArrayList<MerchantStock> getAllMerchantStocks(){
        return merchantStocks;
    }

    public void addMerchantStock(MerchantStock merchantStock){
        merchantStocks.add(merchantStock);
    }

    public ServiceResponse updateMerchantStock(MerchantStock merchantStock, String id){
        for (int i = 0; i < merchantStocks.size(); i++)
            if(merchantStocks.get(i).getId().equals(id)) {
                merchantStocks.set(i, merchantStock);
                return new ServiceResponse(200, "merchantStock with id: "+id+" was updated.");
            }
        return new ServiceResponse(404, "merchantStock with id: "+id+" not found.");
    }

    public ServiceResponse deleteMerchantStock(String id){
        for (int i = 0; i < merchantStocks.size(); i++)
            if(merchantStocks.get(i).getId().equals(id)) {
                merchantStocks.remove(i);
                return new ServiceResponse(200, "merchantStock with id: "+id+" was deleted.");
            }
        return new ServiceResponse(400, "merchantStock with id: "+id+" not found.");
    }
}
