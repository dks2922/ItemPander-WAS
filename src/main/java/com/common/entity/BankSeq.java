package com.common.entity;

import javax.persistence.*;

@Entity
public class BankSeq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int not null comment '고유번호'")
    private Long no;

    @Column(columnDefinition = "varchar(3) null comment '은행 코드'")
    private String bankSeq;
    @Column(columnDefinition = "varchar(10) null comment '은행명'")
    private String bankName;

}
