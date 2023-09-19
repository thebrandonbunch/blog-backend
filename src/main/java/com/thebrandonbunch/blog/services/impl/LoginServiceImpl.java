package com.thebrandonbunch.blog.services.impl;

import com.thebrandonbunch.blog.models.Login;
import com.thebrandonbunch.blog.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl {
    @Autowired
    private LoginRepository loginRepository;
    public Optional<Login> singleLogin(String userId) {
        return loginRepository.findLoginById(userId);
    }
}
