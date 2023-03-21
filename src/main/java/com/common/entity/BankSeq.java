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
    @Column(columnDefinition = "varchar(20) null comment '은행명'")
    private String bankName;

    @Column(columnDefinition = "varchar(30) null comment '종류'")
    private String Kind;

}
