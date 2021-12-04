package com.example.putpostbyuser.controller;

import com.example.putpostbyuser.dto.CommentItem;
import com.example.putpostbyuser.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/s2/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(commentService.findAll());
    }

    @PostMapping
    public ResponseEntity add(@RequestBody CommentItem commentItem){
        return ResponseEntity.ok(commentService.add(commentItem));
    }

    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody CommentItem commentItem, @PathVariable Long id){
        return ResponseEntity.ok(commentService.update(commentItem, id));
    }

    @DeleteMapping("{id}")
    public  ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok(commentService.delete(id));
    }
}
