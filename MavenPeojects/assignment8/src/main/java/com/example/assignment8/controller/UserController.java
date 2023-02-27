package com.example.assignment8.controller;


import com.example.assignment8.entity.User;
import com.example.assignment8.security.JwtTokenUtil;
import com.example.assignment8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));
        final String token = jwtTokenUtil.generateToken(user.getName());
        return ResponseEntity.ok(token);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('Administration')")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }



}
