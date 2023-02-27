package com.example.assignment6.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsSupplier implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long goodsId;
    private Long supplierId;
    private String supplierName;
    private String supplierPhone;
    private String supplierEmail;
}
