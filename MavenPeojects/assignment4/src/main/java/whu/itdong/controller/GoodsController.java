package whu.itdong.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import whu.itdong.common.Result;
import whu.itdong.entity.Goods;
import whu.itdong.service.GoodsService;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Goods good = goodsService.getById(id);
        if(good != null){
            return Result.success(good);
        } else {
            return Result.error("ID错误，查找不到该商品");
        }
    }

    @GetMapping("")
    public Result getByCondition(String name, Double price){
        List<Goods> goods = goodsService.GetByConditions(name, price);
        return Result.success(goods);
    }

    @PostMapping("")
    public Result save(@RequestBody Goods good){
        return Result.success(goodsService.save(good));
    }

    @PutMapping("/{id}")
    public Result updateById(@PathVariable Integer id, @RequestBody Goods good){
        if(goodsService.getById(id) != null){
            goodsService.updateById(id, good);
            return Result.success(good);
        }
        return Result.error("未查询到商品,无法更新，请检查ID");
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        goodsService.deleteById(id);
        return Result.success("删除成功");
    }



}
