package com.example.assignment7.dto;

import com.example.assignment7.entity.Goods;
import com.example.assignment7.entity.Supplier;
import lombok.Data;

import java.util.List;

@Data
public class GoodsDto extends Goods {
    private List<Long> supplierIds;
    private List<Supplier> suppliers;
}
