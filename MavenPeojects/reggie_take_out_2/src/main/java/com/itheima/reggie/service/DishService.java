package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.dto.DishDto;
import com.itheima.reggie.entity.Dish;

import java.util.List;

public interface DishService extends IService<Dish> {

    public void saveWithFlavor(DishDto dishdto);

    //根据id查询菜品信息和口味信息
    public DishDto getByIdWithFlavor(Long id);


    public void updateWithFlavor(DishDto dishDto);

    void deleteById(List<Long> id);
}
