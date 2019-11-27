package com.example.project.dao;

import com.example.project.domain.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GoodsMapper.
 * todo 对应.xml文件的正确性未知
 */
@Mapper
public interface GoodsMapper {

    /**
     * 添加一个货物。
     * @param newGoods  货物对象，将这个对象中不为空的属性存入数据库
     */
    void addGoods(Goods newGoods);

    /**
     * 根据货物ID删除一个货物，如果这个ID不存在将不会有任何影响。
     * @param goodId    货物ID
     */
    void deleteGoodsById(int goodId);

    /**
     * 根据传入的goods对象修改货物信息。
     * @param goods 这个对象的ID属性将作为索引，其他属性是待修改内容，
     *              例如现有一个ID为1，name是苹果的货物，希望修改名字为梨子，
     *              需要将ID设为1，name设为梨子即可
     */
    void updateGoods(Goods goods);

    /**
     * 根据goods的非空属性查找完整信息。
     * @param goods 一个没有现实意义的goods对象，根据这个对象中非空的属性查找，
     *              例如想查找货物名称为"苹果"的货物，
     *              只需要将name设置为苹果，其他为null或者空
     * @return  一个列表，是按照上述条件查找出来的结果
     */
    List<Goods> queryGoods(Goods goods);

    /**
     * 获得货物的库存。
     * @param id    需要查询库存的货物ID
     * @return  货物的库存
     */
    int getStockById(int id);


}
