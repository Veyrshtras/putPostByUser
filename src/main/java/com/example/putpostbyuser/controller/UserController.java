package com.example.putpostbyuser.controller;

import com.example.putpostbyuser.dto.UserItem;
import com.example.putpostbyuser.service.UserService;
import org.hibernate.service.spi.InjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/s2/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public ResponseEntity get(@PathVariable Long id){

        return ResponseEntity.ok(userService.get(id));
    }

    @GetMapping
    public ResponseEntity findAll(){

        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping
    public ResponseEntity add(@RequestBody UserItem userItem){

        return ResponseEntity.ok(userService.add(userItem));
    }

    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody UserItem userItem, @PathVariable Long id){

        return ResponseEntity.ok(userService.update(userItem, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id){

        return ResponseEntity.ok(userService.delete(id));
    }

}
