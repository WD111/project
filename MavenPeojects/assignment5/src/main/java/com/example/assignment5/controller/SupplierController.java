package com.example.assignment5.controller;

import com.example.assignment5.common.Result;
import com.example.assignment5.entity.Goods;
import com.example.assignment5.entity.Supplier;
import com.example.assignment5.service.GoodsService;
import com.example.assignment5.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @Autowired
    GoodsService goodsService;

    @PostMapping("")
    public Result save(@RequestBody Supplier supplier){
        return Result.success(supplierService.save(supplier));
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable long id){
        return Result.success(supplierService.getById(id));
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable long id){
        supplierService.deleteById(id);
        return Result.success("删除成功");
    }

    @PutMapping("/{id}")
    public Result updateById(@PathVariable long id, @RequestBody Supplier supplier){
        return Result.success(supplierService.updateById(id, supplier));
    }

    @PostMapping("/{sId}/{gId}")
    public Result addGoods(@PathVariable long sId, @PathVariable long gId){
        supplierService.addGoods(sId, gId);
        return Result.success();
    }

    @DeleteMapping("/{sId}/{gId}")
    public Result deleteGoods(@PathVariable long sId, @PathVariable long gId){
        supplierService.deleteGoods(sId, gId);
        return Result.success();
    }




    @GetMapping("/goods/{id}")
    public Result getGoodsById(@PathVariable long id){
        return Result.success(supplierService.getGoodsById(id));
    }
}
