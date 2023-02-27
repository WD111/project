package com.example.assignment5.entity;

import lombok.Data;

@Data
public class GoodsInfo {
    private Long gId;

    //产品名称
    private String name;

    //产品单价
    private Double price;

    //库存数量
    private Integer amount;

    //产品类别
    private String category;


    //产品描述
    private String description;
}
