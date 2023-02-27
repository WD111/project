package com.example.assignment7.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.assignment7.controller.request.PageRequest;
import com.example.assignment7.dto.GoodsDto;
import com.example.assignment7.entity.Goods;
import com.github.pagehelper.PageInfo;

public interface GoodsService extends IService<Goods> {
    public boolean saveWithSupplier(GoodsDto goodsDto); //新增
    public GoodsDto getWithSupplier(Long id); //查询
    public void deleteWithSupplier(Long id); //删除
    public boolean updateWithSupplier(GoodsDto goodsDto); //更新
    public PageInfo<GoodsDto> page(PageRequest pageRequest); //分页
}
