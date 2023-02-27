package com.example.assignment5.service;

import com.example.assignment5.common.ServiceException;
import com.example.assignment5.entity.Goods;
import com.example.assignment5.entity.GoodsInfo;
import com.example.assignment5.entity.Supplier;
import com.example.assignment5.entity.SupplierInfo;
import com.example.assignment5.repository.GoodsRepository;
import com.example.assignment5.repository.SupplierRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class GoodsService {
    @Autowired
    GoodsRepository goodsRepository;

    @Autowired
    SupplierRepository supplierRepository;

    public Goods save(Goods good){
        if(good.getGId() != null){
            if(goodsRepository.findById(good.getGId()).isPresent()){
                throw new ServiceException("该商品已存在");
            }
        }
        return goodsRepository.save(good);
    }

    public GoodsInfo getById(long id){
        if(!goodsRepository.findById(id).isPresent()){
            throw new ServiceException("该商品不存在");
        } else {
            Goods good = goodsRepository.findById(id).get();
            GoodsInfo goodsInfo = new GoodsInfo();
            BeanUtils.copyProperties(good, goodsInfo);
            return goodsInfo;
        }
    }

    public GoodsInfo updateById(long id, Goods good){
        if(!goodsRepository.findById(id).isPresent()){
            throw new ServiceException("该商品不存在");
        }
        goodsRepository.saveAndFlush(good);
        GoodsInfo goodsInfo = new GoodsInfo();
        BeanUtils.copyProperties(good, goodsInfo);
        return goodsInfo;
    }

    public void deleteById(long id){
        if(!goodsRepository.findById(id).isPresent()){
            throw new ServiceException("删除失败，该商品不存在");
        } else {
            Goods good = goodsRepository.findById(id).get();
            for(Supplier s : good.getSuppliers()){
                s.getGoods().remove(good);
                supplierRepository.saveAndFlush(s);
            }
            goodsRepository.deleteById(id);
        }
    }

    public void addSupplier(long sId, long gId){
        Goods good = new Goods();
        Supplier supplier = new Supplier();
        if(!goodsRepository.findById(gId).isPresent()){
            throw new ServiceException("该商品不存在!!!");
        } else if (!supplierRepository.findById(sId).isPresent()){
            throw new ServiceException("该供应商不存在!!!");
        } else {
            good = goodsRepository.findById(gId).get();
            supplier = supplierRepository.findById(sId).get();
            if(good.getSuppliers().contains(supplier)){
                throw new ServiceException("添加供应商失败，该商品已存在该供应商！！！");
            }else {
                supplier.getGoods().add(good);
                good.getSuppliers().add(supplier);
                goodsRepository.saveAndFlush(good);
                supplierRepository.saveAndFlush(supplier);
            }
        }
    }

    public void deleteSupplier(long sId, long gId){
        Goods good = new Goods();
        Supplier supplier = new Supplier();
        if(!goodsRepository.findById(gId).isPresent()){
            throw new ServiceException("该商品不存在!!!");
        } else if (!supplierRepository.findById(sId).isPresent()){
            throw new ServiceException("该供应商不存在!!!");
        } else {
            good = goodsRepository.findById(gId).get();
            supplier = supplierRepository.findById(sId).get();
            if(!good.getSuppliers().contains(supplier)){
                throw new ServiceException("删除供应商失败，该商品不存在该供应商！！！");
            }else {
                supplier.getGoods().remove(good);
                good.getSuppliers().remove(supplier);
                goodsRepository.saveAndFlush(good);
                supplierRepository.saveAndFlush(supplier);
            }
        }
    }


    public Set<SupplierInfo> findSupplierByGid(long id){
        Goods good = goodsRepository.findById(id).get();
        Set<SupplierInfo> res = new HashSet<SupplierInfo>();
        for(Object info : good.getSuppliers()){
            SupplierInfo supplierInfo = new SupplierInfo();
            BeanUtils.copyProperties(info, supplierInfo);
            res.add(supplierInfo);
        }
        return res;
    }
}
