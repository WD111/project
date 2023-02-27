package com.example.assignment7.controller;

import com.example.assignment7.aspect.URLAspect;
import com.example.assignment7.common.Result;
import com.example.assignment7.controller.request.PageRequest;
import com.example.assignment7.dto.GoodsDto;
import com.example.assignment7.service.GoodsService;
import com.example.assignment7.service.GoodsSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    URLAspect urlAspect;
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsSupplierService goodsSupplierService;

    /**
     * 新增商品及其供应商ID
     * @param goodsDto
     * @return
     */
    @PostMapping
    public Result save(@RequestBody GoodsDto goodsDto){
        if(!goodsService.saveWithSupplier(goodsDto)){
            return Result.success(this.getById(goodsDto.getId()),"所添加的供应商中有些ID不存在，未添加完全");
        } else {
            urlAspect.getMetrics().forEach((api, metric) -> {
                System.out.println("API:"+api);
                System.out.println(metric);
            });
            return Result.success(this.getById(goodsDto.getId()),"添加成功");
        }
    }

    /**
     * 根据ID查询商品及对应供应商
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable long id){
        return Result.success(goodsService.getWithSupplier(id));
    }

    /**
     * 根据ID删除商品
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable long id){
        goodsService.deleteWithSupplier(id);
        return Result.success("删除商品成功");
    }

    /**
     * 更新商品
     * @param goodsDto
     * @return
     */
    @PutMapping
    public Result update(@RequestBody GoodsDto goodsDto){
        if(goodsService.updateWithSupplier(goodsDto)){
            return Result.success("修改成功");
        } else {
            return Result.success("有供应商不存在，未更新完全");
        }
    }

    /**
     * 分页查询商品
     * @param num
     * @param size
     * @return
     */
    @GetMapping("/page/{num}/{size}")
    public Result page(@PathVariable Integer num, @PathVariable Integer size){
        PageRequest pageRequest = new PageRequest(num, size);
        urlAspect.getMetrics().forEach((api, metric) -> {
            System.out.println("API:"+api);
            System.out.println(metric);
        });
        return Result.success(goodsService.page(pageRequest));
    }


}
