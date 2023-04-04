package com.login.service;

import com.login.repository.LoginRepository;
import exception.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.jwt.JwtTokenProvider;


@Service
public class LoginService {

    @Autowired
    public LoginRepository repository;

    Logger log = LoggerFactory.getLogger(getClass().getName());

    public String authenticateUser(String username, String password) {
        System.out.println("username : " + username);
        System.out.println("password : " + password);

        // username, password 검증 로직
        if (isValidUser(username, password)) {
            return JwtTokenProvider.generateToken(username);
        } else {
            throw new UnauthorizedException("Invalid username or password");
        }
    }

    private boolean isValidUser(String userId, String password) {
        // 사용자 인증 로직
        if (repository.findByUserIdAndPassword(userId, password) == null) {
            return false;
        } else {
            return true;
        }
    }

}
