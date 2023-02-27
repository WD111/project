package whu.itdong.entity;

import lombok.Data;


@Data
public class Goods {

    private Integer id;//商品Id
    private Integer amount;//商品数量
    private String name;//商品名称
    private Double price;//商品价格
    private String code;//商品码
    private String category;//商品分类
    private String description;//商品描述
}
