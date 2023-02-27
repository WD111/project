package com.example.assignment8.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Goods {

    @Id
    @GeneratedValue
    Long id;
    String name;
    float price;
    float stockQuantity;
    String category;
    String productType;
    String description;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    List<Supplier> supplierList=new ArrayList<>();

}
