package com.example.assignment5.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Table(name = "supplier")
@Entity
public class Supplier {

    @Id
    @Column(name = "s_id")
    @GeneratedValue
    private Long sId;

    private String name;

    private String phone;

    private String email;

    @ManyToMany
    //@JoinTable(name = "goods_supplier", joinColumns = {@JoinColumn(name="s_id")}, inverseJoinColumns = {@JoinColumn(name="g_id")})
    private Set<Goods> goods = new HashSet<Goods>();

}
