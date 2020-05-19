package com.bingo.dianping.dal;

import com.bingo.dianping.model.ShopModel;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ShopModelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop
     *
     * @mbg.generated Mon May 18 23:38:03 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop
     *
     * @mbg.generated Mon May 18 23:38:03 CST 2020
     */
    int insert(ShopModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop
     *
     * @mbg.generated Mon May 18 23:38:03 CST 2020
     */
    int insertSelective(ShopModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop
     *
     * @mbg.generated Mon May 18 23:38:03 CST 2020
     */
    ShopModel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop
     *
     * @mbg.generated Mon May 18 23:38:03 CST 2020
     */
    int updateByPrimaryKeySelective(ShopModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop
     *
     * @mbg.generated Mon May 18 23:38:03 CST 2020
     */
    int updateByPrimaryKey(ShopModel record);

    List<ShopModel> selectAll();

    Integer countAllShop();

    /**
     * 推荐1.0
     * @param longitude
     * @param latitude
     * @return
     */
    List<ShopModel> recommend(@Param("longitude") BigDecimal longitude, @Param("latitude") BigDecimal latitude);

    /**
     * 搜索1.0
     * @param longitude
     * @param latitude
     * @param keyword
     * @return
     */
    List<ShopModel> search(@Param("longitude") BigDecimal longitude,
                           @Param("latitude") BigDecimal latitude,
                           @Param("keyword") String keyword,
                           @Param("orderby") Integer orderby,
                           @Param("categoryId") Integer categoryId,
                           @Param("tags") String tags);

    List<Map<String, Object>> searchGroupByTags(@Param("keyword") String keyword,
                                                @Param("categoryId") Integer categoryId,
                                                @Param("tags") String tags);
}