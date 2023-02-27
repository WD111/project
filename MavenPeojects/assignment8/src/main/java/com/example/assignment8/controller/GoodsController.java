package com.example.assignment8.controller;

import com.example.assignment8.entity.Goods;
import com.example.assignment8.exception.GoodsAdminException;
import com.example.assignment8.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @PostMapping
    @PreAuthorize("hasAuthority('/goods/update')")
    public Goods saveGoods(@RequestBody Goods goods) throws GoodsAdminException {
        return goodsService.saveGoods(goods);
    }

    @GetMapping
    public ResponseEntity<Goods> getGoodsById(@PathVariable long id){
        Goods goods = goodsService.getGoodsById(id);
        if(goods == null){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(goods);
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('/goods/update')")
    public void updateGoods(@PathVariable long id, @RequestBody Goods goods) throws GoodsAdminException{
        goodsService.updateGoods(id, goods);
    }

    @DeleteMapping("/{id}")
    public void deleteGoodsById(@PathVariable long id){
        goodsService.deleteGoodsById(id);
    }

}
