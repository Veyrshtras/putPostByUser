package com.example.putpostbyuser.service.impl;

import com.example.putpostbyuser.dto.CategoryItem;
import com.example.putpostbyuser.entity.Category;
import com.example.putpostbyuser.repository.CategoryRepository;
import com.example.putpostbyuser.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryItem> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryItem::fromCategory)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryItem add(CategoryItem user) {
        Category category=new Category();
        category.setDescription(user.getDescription());
        category.setTitle(user.getTitle());
        category.setParent(user.getParent());

        categoryRepository.save(category);
        return user;
    }

    @Override
    public CategoryItem update(CategoryItem user, Long id) {
        Category category=categoryRepository.getOne(id);

        category.setDescription(user.getDescription());
        category.setTitle(user.getTitle());
        category.setParent(user.getParent());

        categoryRepository.save(category);
        return user;
    }

    @Override
    public boolean delete(Long id) {
        categoryRepository.deleteById(id);
        return true;
    }
}
