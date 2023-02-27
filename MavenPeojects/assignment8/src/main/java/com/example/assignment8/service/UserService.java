package com.example.assignment8.service;

import com.example.assignment8.dao.UserRepository;
import com.example.assignment8.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Cacheable(cacheNames = "user", key="#username", condition = "#username!=null")
    public User getByUsername(String username){
        Optional<User> user = userRepository.findById(username);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    @CacheEvict(cacheNames = "user", key="#username")
    public void deleteByUsername(String username){
        userRepository.deleteById(username);
    }

    public User saveUser(User user){
        String password = user.getPassword();
        if(password != null){
            user.setPassword(passwordEncoder.encode(password));
        }
        return userRepository.save(user);
    }

    @Transactional
    public void changePassword(String username, String password){
        userRepository.changePassword(username, passwordEncoder.encode(password));
    }

}
