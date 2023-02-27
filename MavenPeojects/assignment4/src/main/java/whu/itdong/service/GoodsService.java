package whu.itdong.service;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;
import whu.itdong.entity.Goods;

import java.util.*;

@Service
public class GoodsService {
    private Map<Integer, Goods> goodsMap = Collections.synchronizedMap(new HashMap<Integer, Goods>());

    /**
     * 新增商品
     * @param good
     * @return
     */
    public Goods save(Goods good){
        goodsMap.put(good.getId(), good);
        return good;
    }

    /**
     * 根据ID查询商品
     * @param id
     * @return
     */
    public Goods getById(Integer id){
        return goodsMap.get(id);
    }

    /**
     * 更新商品
     * @param id
     * @param good
     */
    public void updateById(Integer id, Goods good){
        if(goodsMap.get(id) != null){
            goodsMap.put(good.getId(), good);
        }
    }

    /**
     * 根据Id删除商品
     * @param id
     */
    public void deleteById(Integer id){
        goodsMap.remove(id);
    }

    /**
     * 商品码查询
     * @param code
     * @return
     */
    public Goods getByCode(String code){
        for(Goods good : goodsMap.values()){
            if(good.getCode() == code){
                return good;
            }
        }
        return null;
    }

    /**
     * 条件查询：名称和价格
     * @param name
     * @param price
     * @return
     */
    public List<Goods> GetByConditions(String name, Double price){
        List<Goods>  goods = new ArrayList<>();
        for(Goods good : goodsMap.values()){
            if(name != null && !good.getName().contains(name)){
                continue;
            }
            if(price != null && !good.getPrice().equals(price)){
                continue;
            }
            goods.add(good);
        }
        return goods;
    }


    public void delete() {
        goodsMap.clear();
    }
}
