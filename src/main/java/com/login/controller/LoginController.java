package com.login.controller;

import com.login.model.Login;
import com.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import util.jwt.JwtAuthenticationResponse;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

//    @PostMapping("/login")
//    public Login authenticateUser(@RequestBody Login login) {
//        System.out.println("login.getId() : " + login.getId());
//        System.out.println("login.getPassword() : " + login.getPassword());
//        String token = loginService.authenticateUser(login.getId(), login.getPassword());
//        System.out.println("token : " + token);
////        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
//        return login;
//    }


    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody Login login) {

        System.out.println("login : " + login);
        String token = loginService.authenticateUser(login.getId(), login.getPassword());
        System.out.println("token : " + token);
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    @GetMapping("/test")
    public void test() {

        System.out.println("rrrssos");

    }

}
