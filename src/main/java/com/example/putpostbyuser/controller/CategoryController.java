package com.example.putpostbyuser.controller;

import com.example.putpostbyuser.dto.CategoryItem;
import com.example.putpostbyuser.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/s2/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }

    @PostMapping
    public ResponseEntity add(@RequestBody CategoryItem categoryItem){
        return ResponseEntity.ok(categoryService.add(categoryItem));
    }

    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody CategoryItem categoryItem, @PathVariable Long id){
        return ResponseEntity.ok(categoryService.update(categoryItem, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.delete(id));
    }
}
