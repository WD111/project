package com.example.assignment6.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.assignment6.common.Result;
import com.example.assignment6.common.ServiceException;
import com.example.assignment6.controller.request.PageRequest;
import com.example.assignment6.dto.GoodsDto;
import com.example.assignment6.entity.Goods;
import com.example.assignment6.entity.GoodsSupplier;
import com.example.assignment6.entity.Supplier;
import com.example.assignment6.mapper.GoodsMapper;
import com.example.assignment6.mapper.GoodsSupplierMapper;
import com.example.assignment6.service.GoodsService;
import com.example.assignment6.service.GoodsSupplierService;
import com.example.assignment6.service.SupplierService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    @Autowired
    GoodsSupplierService goodsSupplierService;

    @Autowired
    SupplierService supplierService;

    /**
     * 新增商品及其对应的供应商（供应商由传递的供应商ID添加）
     * @param goodsDto
     * @return
     */
    @Override
    public boolean saveWithSupplier(GoodsDto goodsDto) {
        boolean flag = true;
        if(this.getById(goodsDto.getId()) != null){
            throw new ServiceException("该商品已存在");
        }
        this.save(goodsDto);
        List<Long> supplierIds = goodsDto.getSupplierIds();
        if(supplierIds != null){
            for(Long g : supplierIds){
                if(supplierService.getById(g)!= null){
                    Supplier supplier = supplierService.getById(g);
                    GoodsSupplier goodsSupplier = new GoodsSupplier();
                    goodsSupplier.setGoodsId(goodsDto.getId());
                    goodsSupplier.setSupplierId(g);
                    goodsSupplier.setSupplierName(supplier.getName());
                    goodsSupplier.setSupplierPhone(supplier.getPhone());
                    goodsSupplier.setSupplierEmail(supplier.getEmail());
                    goodsSupplierService.save(goodsSupplier);
                } else {
                    log.error("不存在ID为" + g + "的供应商");
                    flag = false;
                }
            }
        }
        return flag;
    }

    /**
     * 根据商品ID查询商品及对应供应商
     * @param id
     * @return
     */
    @Override
    public GoodsDto getWithSupplier(Long id) {
        Goods goods = this.getById(id);
        GoodsDto goodsDto = new GoodsDto();

        LambdaQueryWrapper<GoodsSupplier> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(id != null, GoodsSupplier::getGoodsId, id);
        if(goods != null){
            BeanUtils.copyProperties(goods, goodsDto);
            List<GoodsSupplier> goodsSuppliers = goodsSupplierService.list(queryWrapper);
            List<Supplier> res = new ArrayList<>();
            for(GoodsSupplier g : goodsSuppliers){
                res.add(supplierService.getById(g.getSupplierId()));
            }
            goodsDto.setSuppliers(res);
            return goodsDto;
        } else {
            throw new ServiceException("该商品不存在");
        }
    }

    /**
     * 删除商品
     * @param id
     */
    @Override
    public void deleteWithSupplier(Long id) {
        if(this.getById(id) != null){
            LambdaQueryWrapper<GoodsSupplier> queryWrapper = new LambdaQueryWrapper();
            queryWrapper.eq(GoodsSupplier::getGoodsId, id);
            this.removeById(id);
            goodsSupplierService.remove(queryWrapper);
        } else {
            throw new ServiceException("该商品不存在");
        }
    }

    /**
     * 更新商品及对应供应商信息
     * @param goodsDto
     * @return
     */
    @Override
    public boolean updateWithSupplier(GoodsDto goodsDto) {
        boolean flag = true;
        List<Long> SupplierIds = goodsDto.getSupplierIds();
        Long goodsId = goodsDto.getId();
        LambdaQueryWrapper<GoodsSupplier> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(GoodsSupplier::getGoodsId, goodsId);
        goodsSupplierService.remove(queryWrapper);

        for(Long g : SupplierIds){
            if(supplierService.getById(g)!= null){
                Supplier supplier = supplierService.getById(g);
                GoodsSupplier goodsSupplier = new GoodsSupplier();
                goodsSupplier.setGoodsId(goodsDto.getId());
                goodsSupplier.setSupplierId(g);
                goodsSupplier.setSupplierName(supplier.getName());
                goodsSupplier.setSupplierPhone(supplier.getPhone());
                goodsSupplier.setSupplierEmail(supplier.getEmail());
                goodsSupplierService.save(goodsSupplier);
            } else {
                log.error("不存在ID为" + g + "的供应商");
                flag = false;
            }
        }
        this.updateById(goodsDto);
        return flag;
    }

    /**
     * 分页
     * @param pageRequest
     * @return
     */
    @Override
    public PageInfo<GoodsDto> page(PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<Goods> goods = this.list();
        List<GoodsDto> goodsDtos = new ArrayList<>();
        for(Goods g : goods){
            GoodsDto goodsDto = new GoodsDto();
            BeanUtils.copyProperties(g, goodsDto);
            LambdaQueryWrapper<GoodsSupplier> queryWrapper = new LambdaQueryWrapper();
            queryWrapper.eq(GoodsSupplier::getGoodsId, g.getId());
            List<GoodsSupplier> goodsSuppliers = goodsSupplierService.list(queryWrapper);
            List<Supplier> res = new ArrayList<>();
            for(GoodsSupplier s : goodsSuppliers){
                res.add(supplierService.getById(s.getSupplierId()));
            }
            goodsDto.setSuppliers(res);
            goodsDtos.add(goodsDto);
        }
        return new PageInfo<>(goodsDtos);
    }
}
