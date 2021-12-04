package com.example.putpostbyuser.service;

import com.example.putpostbyuser.dto.CategoryItem;

import java.util.List;

public interface CategoryService {

    List<CategoryItem> findAll();

    CategoryItem add(CategoryItem user);

    CategoryItem update(CategoryItem user, Long id);

    boolean delete(Long id);
}
