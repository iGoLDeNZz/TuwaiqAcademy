package com.example.week_3_project.service;

import com.example.week_3_project.model.Category;
import com.example.week_3_project.model.Merchant;
import com.example.week_3_project.utility.ServiceResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {

    ArrayList<Category> categories = new ArrayList<>();

    public ArrayList<Category> getAllCategories(){
        return categories;
    }

    public void addCategory(Category category){
        categories.add(category);
    }

    public ServiceResponse updateCategory(Category category, String id){
        for (int i = 0; i < categories.size(); i++)
            if(categories.get(i).getId().equals(id)) {
                categories.set(i, category);
                return new ServiceResponse(200, "category with id: "+id+" was updated.");
            }
        return new ServiceResponse(404, "category with id: "+id+" not found.");
    }

    public ServiceResponse deleteCategory(String id){
        for (int i = 0; i < categories.size(); i++)
            if(categories.get(i).getId().equals(id)) {
                categories.remove(i);
                return new ServiceResponse(200, "category with id: "+id+" was deleted.");
            }
        return new ServiceResponse(400, "category with id: "+id+" not found.");
    }
}
