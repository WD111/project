package com.example.assignment6.dto;

import com.example.assignment6.entity.Goods;
import com.example.assignment6.entity.GoodsSupplier;
import com.example.assignment6.entity.Supplier;
import lombok.Data;

import java.util.List;

@Data
public class GoodsDto extends Goods {
    private List<Long> supplierIds;
    private List<Supplier> suppliers;
}
