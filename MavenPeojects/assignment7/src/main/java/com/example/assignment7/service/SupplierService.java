package com.example.assignment7.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.assignment7.controller.request.PageRequest;
import com.example.assignment7.dto.SupplierDto;
import com.example.assignment7.entity.Supplier;
import com.github.pagehelper.PageInfo;

public interface SupplierService extends IService<Supplier> {
    public boolean saveWithGoods(SupplierDto supplierDto);
    public SupplierDto getWithGoods(Long id);
    public void deleteWithGoods(Long id);
    public boolean updateWithGoods(SupplierDto supplierDto);
    public PageInfo<SupplierDto> page(PageRequest pageRequest);
}
