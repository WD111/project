package com.example.assignment5.controller;


import com.example.assignment5.common.Result;
import com.example.assignment5.entity.Goods;
import com.example.assignment5.entity.Supplier;
import com.example.assignment5.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @PostMapping("")
    public Result save(@RequestBody Goods good){
        return Result.success(goodsService.save(good));
    }

    @PostMapping("/{gId}/{sId}")
    public Result addSupplier(@PathVariable long sId, @PathVariable long gId){
        goodsService.addSupplier(sId, gId);
        return Result.success();
    }

    @DeleteMapping("/{gId}/{sId}")
    public Result deleteSupplier(@PathVariable long sId, @PathVariable long gId){
        goodsService.deleteSupplier(sId, gId);
        return Result.success();
    }

    @PutMapping("/{id}")
    public Result updateById(@PathVariable long id, @RequestBody Goods good){
        return Result.success(goodsService.updateById(id, good));
    }


    @GetMapping("/supplier/{id}")
    public Result getSuppliers(@PathVariable long id){
        return Result.success(goodsService.findSupplierByGid(id));
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable long id){
        return Result.success(goodsService.getById(id));
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable long id){
        goodsService.deleteById(id);
        return Result.success("删除成功");
    }

}
