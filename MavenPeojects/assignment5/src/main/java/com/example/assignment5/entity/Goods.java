package com.example.assignment5.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jiaxy
 */


@Getter
@Setter
@Table(name = "goods")
@Entity
public class Goods {

    //产品Id
    @Id
    @GeneratedValue
    @Column(name = "g_id")
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

    //供应商
    @ManyToMany
    @JoinTable(name = "goods_supplier", joinColumns = {@JoinColumn(name="g_id")}, inverseJoinColumns = {@JoinColumn(name="s_id")})
    private Set<Supplier> suppliers = new HashSet<Supplier>();

}
