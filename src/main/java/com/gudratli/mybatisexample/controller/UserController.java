package com.gudratli.mybatisexample.controller;

import com.gudratli.mybatisexample.entity.User;
import com.gudratli.mybatisexample.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserMapper userMapper;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userMapper.findAll());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userMapper.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        userMapper.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> updateUser(@RequestBody User user) {
        userMapper.update(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userMapper.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}