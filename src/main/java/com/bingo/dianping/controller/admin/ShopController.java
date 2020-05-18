package com.bingo.dianping.controller.admin;

import com.bingo.dianping.common.BusinessException;
import com.bingo.dianping.common.CommonUtils;
import com.bingo.dianping.common.ErrorCodeEnum;
import com.bingo.dianping.common.interceptor.AdminPermission;
import com.bingo.dianping.model.CategoryModel;
import com.bingo.dianping.model.ShopModel;
import com.bingo.dianping.request.PageQuery;
import com.bingo.dianping.request.ShopCreateReq;
import com.bingo.dianping.service.ShopService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @Author: jiangjiabin
 * @Date: Create in 23:11 2020/5/18
 * @Description:
 */
@Controller("/admin/shop")
@RequestMapping("/admin/shop")
public class ShopController {

    @Resource
    private ShopService shopService;


    //门店列表
    @RequestMapping("/index")
    @AdminPermission
    public ModelAndView index(PageQuery pageQuery) {
        PageHelper.startPage(pageQuery.getPage(), pageQuery.getSize());
        List<ShopModel> categoryModelList = shopService.selectAll();
        PageInfo<ShopModel> shopModelPageInfo = new PageInfo<>(categoryModelList);
        ModelAndView modelAndView = new ModelAndView("/admin/shop/index.html");
        modelAndView.addObject("data", shopModelPageInfo);
        modelAndView.addObject("CONTROLLER_NAME", "shop");
        modelAndView.addObject("ACTION_NAME", "index");
        return modelAndView;
    }

    @RequestMapping("/createPage")
    @AdminPermission
    public ModelAndView createPage() {
        ModelAndView modelAndView = new ModelAndView("/admin/shop/create.html");
        modelAndView.addObject("CONTROLLER_NAME", "shop");
        modelAndView.addObject("ACTION_NAME", "create");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @AdminPermission
    public String create(@Valid ShopCreateReq shopCreateReq, BindingResult bindingResult) throws BusinessException {
        if (bindingResult.hasErrors()) {
            throw new BusinessException(ErrorCodeEnum.PARAMETER_VALIDATE_ERROR, CommonUtils.processErrorString(bindingResult));
        }
        ShopModel shopModel = new ShopModel();
        shopModel.setName(shopCreateReq.getName());
        shopModel.setPricePerMan(shopCreateReq.getPricePerMan());
        shopModel.setLatitude(shopCreateReq.getLatitude());
        shopModel.setLongitude(shopCreateReq.getLongitude());
        shopModel.setCategoryId(shopCreateReq.getCategoryId());
        shopModel.setTags(shopCreateReq.getTags());
        shopModel.setStartTime(shopCreateReq.getStartTime());
        shopModel.setEndTime(shopCreateReq.getEndTime());
        shopModel.setAddress(shopCreateReq.getAddress());
        shopModel.setSellerId(shopCreateReq.getSellerId());
        shopModel.setIconUrl(shopCreateReq.getIconUrl());

        shopService.create(shopModel);

        return "redirect:/admin/shop/index";
    }


}
