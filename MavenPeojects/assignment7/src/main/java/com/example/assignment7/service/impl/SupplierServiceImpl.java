package com.example.assignment7.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.assignment7.common.ServiceException;
import com.example.assignment7.controller.request.PageRequest;
import com.example.assignment7.dto.SupplierDto;
import com.example.assignment7.entity.Goods;
import com.example.assignment7.entity.GoodsSupplier;
import com.example.assignment7.entity.Supplier;
import com.example.assignment7.mapper.SupplierMapper;
import com.example.assignment7.service.GoodsService;
import com.example.assignment7.service.GoodsSupplierService;
import com.example.assignment7.service.SupplierService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements SupplierService {
    @Autowired
    GoodsService goodsService;
    @Autowired
    GoodsSupplierService goodsSupplierService;


    @Override
    public boolean saveWithGoods(SupplierDto supplierDto) {
        if(this.getById(supplierDto.getId()) != null){
            throw new ServiceException("该供应商已存在");
        }
        boolean flag = true;
        this.save(supplierDto);
        List<Long> goodsIds = supplierDto.getGoodsIds();
        if(goodsIds != null){
            for(Long g : goodsIds){
                LambdaQueryWrapper<GoodsSupplier> queryWrapper = new LambdaQueryWrapper();
                queryWrapper.eq(GoodsSupplier::getSupplierId, supplierDto.getId());
                queryWrapper.eq(g != null, GoodsSupplier::getGoodsId, g);
                int count = goodsSupplierService.count(queryWrapper);
                if(goodsService.getById(g) == null){
                    log.error("不存在ID为 " + g + "的商品");
                    flag = true;
                } else if (count <= 0){
                    GoodsSupplier goodsSupplier = new GoodsSupplier();
                    goodsSupplier.setGoodsId(g);
                    goodsSupplier.setSupplierId(supplierDto.getId());
                    goodsSupplier.setSupplierName(supplierDto.getName());
                    goodsSupplier.setSupplierPhone(supplierDto.getPhone());
                    goodsSupplier.setSupplierEmail(supplierDto.getEmail());
                    goodsSupplierService.save(goodsSupplier);
                }
            }
        }
        return flag;
    }

    @Override
    public SupplierDto getWithGoods(Long id) {
        Supplier supplier = this.getById(id);
        SupplierDto supplierDto = new SupplierDto();
        LambdaQueryWrapper<GoodsSupplier> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(GoodsSupplier::getSupplierId, id);
        if(supplier != null){
            BeanUtils.copyProperties(supplier, supplierDto);
            List<GoodsSupplier> goodsSupplierList = goodsSupplierService.list(queryWrapper);
            List<Goods> res = new ArrayList<>();
            for(GoodsSupplier g : goodsSupplierList){
                res.add(goodsService.getById(g.getGoodsId()));
            }
            supplierDto.setGoodsList(res);
            return supplierDto;
        } else {
            throw new ServiceException("该供应商不存在");
        }
    }

    @Override
    public void deleteWithGoods(Long id) {
        if(this.getById(id) != null){
            LambdaQueryWrapper<GoodsSupplier> queryWrapper = new LambdaQueryWrapper();
            queryWrapper.eq(GoodsSupplier::getSupplierId, id);
            this.removeById(id);
            goodsSupplierService.remove(queryWrapper);
        } else {
            throw new ServiceException("该供应商不存在");
        }
    }

    @Override
    public boolean updateWithGoods(SupplierDto supplierDto) {
        boolean flag = true;
        List<Long> goodsIds = supplierDto.getGoodsIds();
        Long supplierId = supplierDto.getId();
        LambdaQueryWrapper<GoodsSupplier> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(GoodsSupplier::getSupplierId, supplierId);
        goodsSupplierService.remove(queryWrapper);

        for(Long g : goodsIds){
            if(goodsService.getById(g)!= null){
                GoodsSupplier goodsSupplier = new GoodsSupplier();
                goodsSupplier.setGoodsId(g);
                goodsSupplier.setSupplierId(supplierDto.getId());
                goodsSupplier.setSupplierName(supplierDto.getName());
                goodsSupplier.setSupplierPhone(supplierDto.getPhone());
                goodsSupplier.setSupplierEmail(supplierDto.getEmail());
                goodsSupplierService.save(goodsSupplier);
            } else {
                log.error("不存在ID为" + g + "的供应商");
                flag = false;
            }
        }
        this.updateById(supplierDto);
        return flag;
    }

    @Override
    public PageInfo<SupplierDto> page(PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<Supplier> suppliers = this.list();
        List<SupplierDto> supplierDtos = new ArrayList<>();
        for(Supplier s : suppliers){
            SupplierDto supplierDto = new SupplierDto();
            BeanUtils.copyProperties(s, supplierDto);
            LambdaQueryWrapper<GoodsSupplier> queryWrapper = new LambdaQueryWrapper();
            queryWrapper.eq(GoodsSupplier::getSupplierId, s.getId());
            List<GoodsSupplier> goodsSuppliers = goodsSupplierService.list(queryWrapper);
            List<Goods> res = new ArrayList<>();
            for(GoodsSupplier g : goodsSuppliers){
                res.add(goodsService.getById(g.getGoodsId()));
            }
            supplierDto.setGoodsList(res);
            supplierDtos.add(supplierDto);
        }
        return new PageInfo<>(supplierDtos);
    }
}
