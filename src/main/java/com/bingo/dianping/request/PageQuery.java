package com.bingo.dianping.request;

import lombok.Data;

/**
 * @Author: jiangjiabin
 * @Date: Create in 22:17 2020/5/17
 * @Description:
 */
@Data
public class PageQuery {

    private Integer page = 1;
    private Integer size = 20;

}
