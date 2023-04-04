package com.user.service;

import com.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    public UserRepository repository;

    Logger log = LoggerFactory.getLogger(getClass().getName());

}
