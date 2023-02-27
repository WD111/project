package com.example.community.service;

import cn.hutool.crypto.SecureUtil;
import com.example.community.dao.UserRepository;
import com.example.community.dto.QuestionDto;
import com.example.community.entity.Question;
import com.example.community.entity.User;
import com.example.community.exception.ServiceException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User addUser(User user){
        if(!userRepository.findById(user.getId()).isPresent()){
            String psw = user.getPassword();
            user.setPassword(SecureUtil.md5(psw));
            return userRepository.saveAndFlush(user);
        } else {
            throw new ServiceException("该账号已注册");
        }
    }

    public void deleteUser(String id){
        userRepository.deleteById(id);
    }

}
