package com.user.repository;

import com.user.entity.UserMember;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserMember, Integer> {

    Page<UserMember> findAll(Pageable pageable);

    List<UserMember> findAllByIdLike(String id);


}