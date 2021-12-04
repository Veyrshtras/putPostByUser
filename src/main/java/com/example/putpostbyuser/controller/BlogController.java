package com.example.putpostbyuser.controller;

import com.example.putpostbyuser.dto.BlogItem;
import com.example.putpostbyuser.service.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/s2/blog")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(blogService.findAll());
    }

    @PostMapping
    public ResponseEntity add(@RequestBody BlogItem blogItem){
        return ResponseEntity.ok(blogService.add(blogItem));
    }

    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody BlogItem blogItem, @PathVariable Long id){
        return ResponseEntity.ok(blogService.update(blogItem, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok(blogService.delete(id));
    }
}
