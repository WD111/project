package com.example.assignment7.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.assignment7.entity.GoodsSupplier;
import com.example.assignment7.mapper.GoodsSupplierMapper;
import com.example.assignment7.service.GoodsSupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GoodsSupplierServiceImpl extends ServiceImpl<GoodsSupplierMapper, GoodsSupplier> implements GoodsSupplierService {
}
