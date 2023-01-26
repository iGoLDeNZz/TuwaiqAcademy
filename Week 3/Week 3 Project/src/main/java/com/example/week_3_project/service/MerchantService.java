package com.example.week_3_project.service;

import com.example.week_3_project.model.Merchant;
import com.example.week_3_project.model.User;
import com.example.week_3_project.utility.ServiceResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {

    ArrayList<Merchant> merchants = new ArrayList<>();

    public ArrayList<Merchant> getAllMerchants(){
        return merchants;
    }

    public void addMerchant(Merchant merchant){
        merchants.add(merchant);
    }

    public ServiceResponse updateMerchant(Merchant merchant, String id){
        for (int i = 0; i < merchants.size(); i++)
            if(merchants.get(i).getId().equals(id)) {
                merchants.set(i, merchant);
                return new ServiceResponse(200, "merchant with id: "+id+" was updated.");
            }
        return new ServiceResponse(404, "merchant with id: "+id+" not found.");
    }

    public ServiceResponse deleteMerchant(String id){
        for (int i = 0; i < merchants.size(); i++)
            if(merchants.get(i).getId().equals(id)) {
                merchants.remove(i);
                return new ServiceResponse(200, "merchant with id: "+id+" was deleted.");
            }
        return new ServiceResponse(400, "merchant with id: "+id+" not found.");
    }
}
