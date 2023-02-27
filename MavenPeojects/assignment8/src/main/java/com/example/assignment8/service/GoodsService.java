package com.example.assignment8.service;

import com.example.assignment8.dao.GoodsRepository;
import com.example.assignment8.entity.Goods;
import com.example.assignment8.exception.GoodsAdminException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {
    @Autowired
    GoodsRepository goodsRepository;

    public Goods saveGoods(Goods goods) throws GoodsAdminException{
        if(goods.getId() != null){
            if(goodsRepository.findById(goods.getId()).isPresent()){
                throw new GoodsAdminException("商品已存在");
            }
        }
        return goodsRepository.save(goods);
    }

    public Goods getGoodsById(long id){
        return goodsRepository.findById(id).get();
    }

    public void updateGoods(long id, Goods goods) throws GoodsAdminException{
        if(!goodsRepository.findById(id).isPresent()){
            throw new GoodsAdminException("该商品不存在");
        }
        goodsRepository.saveAndFlush(goods);
    }

    public void deleteGoodsById(long id){
        goodsRepository.deleteById(id);
    }

}
