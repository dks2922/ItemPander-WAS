package com.itempander.login;

import com.login.repository.LoginRepository;
import com.login.service.LoginService;
import com.user.entity.UserMember;
import com.user.entity.UserMemberDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
public class LoginTests {

    @MockBean
    private AuthenticationManager authenticationManager;

    @Autowired
    LoginService loginService;

    @Autowired
    LoginRepository repository;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void login() {
        String id = "as123";
        String password = "password2";

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(id, password, authorities);
        System.out.println("authToken : " + authToken);

//        authToken.setAuthenticated(true);
//        authToken.setDetails(deta);

        Authentication authentication = authenticationManager.authenticate(authToken);
        System.out.println("authentication :  " + authentication);


        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("SecurityContextHolder.getContext() : " + SecurityContextHolder.getContext());
    }


    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    public void testEncodePassword() {
        String id = "dsa";
        String password = "123";
        String encodedPassword = passwordEncoder.encode(password);
        System.out.println("encodedPassword : " + encodedPassword);

        UserMember userMember = repository.findByUserId(id);
        System.out.println(passwordEncoder.matches("123", encodedPassword));


//        Assertions.assertTrue(passwordEncoder.matches(userMember.getPassword(), encodedPassword));
    }

}
