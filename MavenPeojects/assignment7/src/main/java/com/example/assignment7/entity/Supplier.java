package com.example.assignment7.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "s_id")
    private Long id;

    private String name;
    private String phone;
    private String email;
}
