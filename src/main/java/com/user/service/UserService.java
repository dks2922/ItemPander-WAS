package com.user.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.entity.UserMember;
import com.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Service
@EnableJpaAuditing
public class UserService {

    @Autowired
    public UserRepository repository;

    Logger log = LoggerFactory.getLogger(getClass().getName());

    /**
     * 회원 전체 리스트
     *
     * @param pageable
     * @return
     */
    public Page<UserMember> userMemberList(Pageable pageable) {
        log.debug("==================UserService.userMemberList.START==================");
        Page<UserMember> result = repository.findAll(pageable);
        log.debug("==================UserService.userMemberList.END==================");
        return result;
    }

    /**
     * 회원상세 페이지
     *
     * @param no
     * @return
     */
    public UserMember userMemberDetail(int no) {
        log.debug("==================UserService.userMemberDetail.START==================");
        UserMember result = repository.findById(no).get();
        log.debug("최종 결과값 : " + result);
        log.debug("==================UserService.userMemberDetail.END==================");
        return result;
    }

}
