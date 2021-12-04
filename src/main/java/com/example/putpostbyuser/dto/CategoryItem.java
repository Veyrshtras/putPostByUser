package com.example.putpostbyuser.dto;

import com.example.putpostbyuser.entity.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Getter
@Setter
public class CategoryItem {

    private String title;

    private String description;

    private Category parent;

    public static CategoryItem fromCategory(Category category){
        CategoryItem categoryItem=new CategoryItem();
        categoryItem.setDescription(category.getDescription());
        categoryItem.setParent(category.getParent());
        categoryItem.setTitle(category.getTitle());
        return categoryItem;
    }
}
