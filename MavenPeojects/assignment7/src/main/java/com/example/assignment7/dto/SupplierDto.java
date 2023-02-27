package com.example.assignment7.dto;

import com.example.assignment7.entity.Goods;
import com.example.assignment7.entity.Supplier;
import lombok.Data;

import java.util.List;

@Data
public class SupplierDto extends Supplier {
    private List<Long> goodsIds;
    private List<Goods> goodsList;
}
