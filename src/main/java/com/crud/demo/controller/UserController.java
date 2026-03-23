package com.crud.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.crud.demo.model.UserModel;
import com.crud.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    
    @GetMapping
    public ResponseEntity<List<UserModel>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }
    
    @PostMapping
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel user) {
        return ResponseEntity.status(201).body(userService.createUser(user));
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserModel> getUser(@PathVariable String username) {
        UserModel user = userService.getUserByUsername(username);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UserModel> editUser(@PathVariable Long id, @RequestBody UserModel user) {
        try {
            user.setId(id);
            userService.editUser(user);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("User deleted with id: " + id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error deleting user: " + e.getMessage());
        }
    }
}