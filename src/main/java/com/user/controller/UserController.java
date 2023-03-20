package com.user.controller;

import com.user.entity.UserMember;
import com.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    private Logger log = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    UserService userservice;

    /**
     * 회원 리스트화면 (조회)
     *
     * @param pageable
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = {"/userMemberList", "/userMemberListForm"})
    public List getUserMemberList(
            @PageableDefault(page = 0, size = 10, sort = "no", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        log.debug("==================UserController.getUserMemberList.START==================");

        List result_li = new ArrayList();
        HashMap result_hs = new HashMap();

        Page<UserMember> list = userservice.userMemberList(pageable);
        int currPage = list.getPageable().getPageNumber();
        int totalPage = list.getTotalPages();
        int startPage = (int) Math.floor(currPage / 10) * 10;
        int endPage = Math.min(totalPage, startPage + 10);


        result_hs.put("currPage", currPage);
        result_hs.put("startPage", startPage);
        result_hs.put("endPage", endPage);
        result_hs.put("totalPage", totalPage);
        result_li.add(list.getContent());
        result_li.add(result_hs);

        log.debug("==================UserController.getUserMemberList.END==================");
        return result_li;
    }
}
