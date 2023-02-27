package com.example.assignment7.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class Goods implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "g_id")
    private Long id;

    private String category;

    private String description;

    private String name;

    private Double price;

    private Integer amount;


}
