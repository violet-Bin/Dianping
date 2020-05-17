package com.bingo.dianping.service;

import com.bingo.dianping.common.BusinessException;
import com.bingo.dianping.model.CategoryModel;

import java.util.List;

/**
 * @Author: jiangjiabin
 * @Date: Create in 21:58 2020/5/17
 * @Description:
 */
public interface CategoryService {

    CategoryModel create(CategoryModel categoryModel) throws BusinessException;
    CategoryModel get(Integer id);
    List<CategoryModel> selectAll();

}
