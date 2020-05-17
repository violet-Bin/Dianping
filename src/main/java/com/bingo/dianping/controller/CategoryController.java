package com.bingo.dianping.controller;

import com.bingo.dianping.common.Result;
import com.bingo.dianping.model.CategoryModel;
import com.bingo.dianping.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: jiangjiabin
 * @Date: Create in 23:06 2020/5/17
 * @Description:
 */
@Controller("/category")
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;


    @RequestMapping("/list")
    @ResponseBody
    public Result list() {
        List<CategoryModel> categoryModels = categoryService.selectAll();
        return Result.create(categoryModels);
    }




}
