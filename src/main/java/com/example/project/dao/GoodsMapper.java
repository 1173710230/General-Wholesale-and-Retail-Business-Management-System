package com.example.project.dao;

import com.example.project.domain.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * GoodsMapper.
 * todo 对应.xml文件的正确性未知
 */
@Mapper
public interface GoodsMapper {

    /**
     * 添加一个货物。
     *
     * @param newGoods 货物对象，将这个对象中不为空的属性存入数据库
     */
    int addGoods(Goods newGoods);

    /**
     * 添加货物和数量。
     * 这个方法需要完成两步操作，第一将货物添加到货物表，第二满足货物分配到仓库的关系。
     * 调用此方法时确保是新的货物！
     *
     * @param newGoods 带添加的货物，必须给goodsId和warehouseID和number的值
     */
    void addGoodsWarehouseRelation(Goods newGoods);

    /**
     * 根据货物ID删除一个货物，如果这个ID不存在将不会有任何影响。
     *
     * @param goodId 货物ID
     */
    void deleteGoodsById(int goodId);

    /**
     * 根据传入的goods对象修改货物信息。
     *
     * @param goods 这个对象的ID属性将作为索引，其他属性是待修改内容，
     *              例如现有一个ID为1，name是苹果的货物，希望修改名字为梨子，
     *              需要将ID设为1，name设为梨子即可
     */
    void updateGoods(Goods goods);

    /**
     * 根据goods的非空属性查找完整信息。
     *
     * @param goods 一个没有现实意义的goods对象，根据这个对象中非空的属性查找，
     *              例如想查找货物名称为"苹果"的货物，
     *              只需要将name设置为苹果，其他为null或者空
     *
     *              几个示例：
     *              1. 如果希望查找1号货物在1号仓库的信息，
     *              只需将Goods对象的goodsId设置为1，warehouseId 设置为1，这样查询出来
     *              的将是Goods对象，如果List长度大于0，说明查询到了，否则未查询到；
     *              2. 如果希望查询1号仓库的所有货物的详情，只需要将Goods对象的
     *              warehouseId 设置为1即可。
     *
     * @return 一个列表，是按照上述条件查找出来的结果
     */
    List<Goods> queryGoods(Goods goods);

    /**
     * 直接修改库存。
     *
     * @param goodsId    要修改库存的货物ID
     * @param newNumber 新的数量
     */
    void changeStock(@Param("goodsId") int goodsId, @Param("newNumber") double newNumber);

    /**
     * 根据goods的非空属性查找完整信息。
     * <p>
     * 注意！这里查询出来的商品信息中，number是总库存，不是单个仓库中的库存！并且warehouseId为空值！
     *
     * @param goods 一个没有现实意义的goods对象，根据这个对象中非空的属性查找，
     *              例如想查找货物名称为"苹果"的货物，
     *              只需要将name设置为苹果，其他为null或者空
     * @return 一个列表，是按照上述条件查找出来的结果
     */
    List<Goods> queryGoodsInStock(Goods goods);

    /**
     * 增加库存。
     *
     * @param goodsId   货物ID
     * @param addNumber 增加数量
     */
    void addNumber(@Param("goodsId") int goodsId, @Param("addNumber") double addNumber);

    /**
     * 减少库存。
     *
     * @param goodsId      货物ID
     * @param reduceNumber 减少数量
     */
    void reduceNumber(@Param("goodsId") int goodsId, @Param("reduceNumber") double reduceNumber);



}
