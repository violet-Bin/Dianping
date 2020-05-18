package com.bingo.dianping.controller;

import com.bingo.dianping.common.BusinessException;
import com.bingo.dianping.common.ErrorCodeEnum;
import com.bingo.dianping.common.Result;
import com.bingo.dianping.model.ShopModel;
import com.bingo.dianping.service.CategoryService;
import com.bingo.dianping.service.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: jiangjiabin
 * @Date: Create in 0:24 2020/5/19
 * @Description:
 */
@Controller("/shop")
@RequestMapping("/shop")
public class ShopController {

    @Resource
    private ShopService shopService;

    @Resource
    private CategoryService categoryService;

    //推荐服务
    @RequestMapping("/recommend")
    @ResponseBody
    public Result recommend(@RequestParam(name = "longitude") BigDecimal longitude,
    @RequestParam(name = "latitude") BigDecimal latitude) throws BusinessException {

        if (longitude == null || latitude == null) {
            throw new BusinessException(ErrorCodeEnum.PARAMETER_VALIDATE_ERROR);
        }

        List<ShopModel> shopModels = shopService.recommend(longitude, latitude);
        return Result.create(shopModels);



    }


}
