package com.itempander.login;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class LoginTests {

    @MockBean
    private AuthenticationManager authenticationManager;



    @Test
    public void login(){
        String id = "as123";
        String password = "password2";

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(id, password, authorities);
        System.out.println("authToken : " + authToken);

//        authToken.setAuthenticated(true);
//        authToken.setDetails(deta);

        Authentication authentication = authenticationManager.authenticate(authToken);
        System.out.println("authentication :  "+ authentication);


        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("SecurityContextHolder.getContext() : " + SecurityContextHolder.getContext());
    }
}
