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
import java.util.Set;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    GoodsRepository goodsRepository;

    public Supplier save(Supplier supplier){
        if(supplier.getSId() != null){
            if(supplierRepository.findById(supplier.getSId()).isPresent()){
                throw new ServiceException("添加失败，该供应商已存在");
            }
        }
//        supplier.getGoods().add(good);
        return supplierRepository.saveAndFlush(supplier);
    }

    public SupplierInfo getById(long id){
        if(!supplierRepository.findById(id).isPresent()){
            throw  new ServiceException("该供应商不存在");
        } else {
            Supplier supplier = supplierRepository.findById(id).get();
            SupplierInfo supplierInfo = new SupplierInfo();
            BeanUtils.copyProperties(supplier, supplierInfo);
            return supplierInfo;
        }
    }

    public SupplierInfo updateById(long id, Supplier supplier){
        if(!supplierRepository.findById(id).isPresent()){
            throw new ServiceException("该商品不存在");
        }
        supplierRepository.saveAndFlush(supplier);
        SupplierInfo supplierInfo = new SupplierInfo();
        BeanUtils.copyProperties(supplier, supplierInfo);
        return supplierInfo;
    }

    public void deleteById(long id){
        if(!supplierRepository.findById(id).isPresent()){
            throw new ServiceException("删除失败，该商品不存在");
        } else {
            Supplier supplier = supplierRepository.findById(id).get();
            for(Goods s : supplier.getGoods()){
                s.getSuppliers().remove(supplier);
                goodsRepository.saveAndFlush(s);
            }
            supplierRepository.deleteById(id);
        }
    }

    public void addGoods(long sId, long gId){
        Goods good = new Goods();
        Supplier supplier = new Supplier();
        if(!supplierRepository.findById(sId).isPresent()){
            throw new ServiceException("该供应商不存在!!!");
        } else if (!goodsRepository.findById(gId).isPresent()){
            throw new ServiceException("该商品不存在!!!");
        } else {
            good = goodsRepository.findById(gId).get();
            supplier = supplierRepository.findById(sId).get();
            if(supplier.getGoods().contains(good)){
                throw new ServiceException("添加商品失败，该供应商已存在该商品！！！");
            }else {
                supplier.getGoods().add(good);
                good.getSuppliers().add(supplier);
                goodsRepository.saveAndFlush(good);
                supplierRepository.saveAndFlush(supplier);
            }
        }
    }

    public void deleteGoods(long sId, long gId){
        Goods good = new Goods();
        Supplier supplier = new Supplier();
        if(!goodsRepository.findById(gId).isPresent()){
            throw new ServiceException("该商品不存在!!!");
        } else if (!supplierRepository.findById(sId).isPresent()){
            throw new ServiceException("该供应商不存在!!!");
        } else {
            good = goodsRepository.findById(gId).get();
            supplier = supplierRepository.findById(sId).get();
            if(!supplier.getGoods().contains(good)){
                throw new ServiceException("删除商品失败，该供应商不存在该商品！！！");
            }else {
                supplier.getGoods().remove(good);
                good.getSuppliers().remove(supplier);
                goodsRepository.saveAndFlush(good);
                supplierRepository.saveAndFlush(supplier);
            }
        }
    }

    public Set<GoodsInfo> getGoodsById(long id){
        if(!supplierRepository.findById(id).isPresent()){
            throw new ServiceException("该供应商不存在");
        } else {
            Supplier supplier = supplierRepository.findById(id).get();
            Set<GoodsInfo> res = new HashSet<GoodsInfo>();
            for(Object info : supplier.getGoods()){
                GoodsInfo goodsInfo = new GoodsInfo();
                BeanUtils.copyProperties(info, goodsInfo);
                res.add(goodsInfo);
            }
            return res;
        }
    }
}
