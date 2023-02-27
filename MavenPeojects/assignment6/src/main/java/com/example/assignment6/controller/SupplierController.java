package com.example.assignment6.controller;

import com.example.assignment6.common.Result;
import com.example.assignment6.controller.request.PageRequest;
import com.example.assignment6.dto.SupplierDto;
import com.example.assignment6.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    /**
     * 新增供应商及对应商品（只增加不存在的供应商-商品信息）
     * @param supplierDto
     * @return
     */
    @PostMapping
    public Result save(@RequestBody SupplierDto supplierDto){
        if(supplierService.saveWithGoods(supplierDto)){
            return Result.success("添加成功");
        } else {
            return Result.success("有商品ID不存在，未全部添加，请检查");
        }
    }

    /**
     * 查询供应商
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Long id){
        return Result.success(supplierService.getWithGoods(id));
    }

    /**
     * 删除供应商
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        supplierService.deleteWithGoods(id);
        return Result.success("删除成功");
    }

    /**
     * 更新供应商
     * @param supplierDto
     * @return
     */
    @PutMapping
    public Result update(@RequestBody SupplierDto supplierDto){
        if(supplierService.updateWithGoods(supplierDto)){
            return Result.success("修改成功");
        } else {
            return Result.success("有商品不存在，未更新完全");
        }
    }

    /**
     * 分页查询
     * @param num
     * @param size
     * @return
     */
    @GetMapping("/page/{num}/{size}")
    public Result page(@PathVariable Integer num, @PathVariable Integer size){
        PageRequest pageRequest = new PageRequest(num, size);
        return Result.success(supplierService.page(pageRequest));
    }


}
