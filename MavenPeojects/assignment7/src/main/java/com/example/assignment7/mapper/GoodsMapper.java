package com.example.assignment7.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.assignment7.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
}
