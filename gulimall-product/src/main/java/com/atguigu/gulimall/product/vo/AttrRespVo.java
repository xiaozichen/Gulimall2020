package com.atguigu.gulimall.product.vo;

import lombok.Data;

/**
 * Created with IntelliJ IDEA
 * User: GHYANG
 * Date: 2020-06-01
 * Description:
 */
@Data
public class AttrRespVo extends AttrVo{
    /**
     * "catelogName":"手机/数码/手机”，//所需分类名字
     * "groupName":"主体"，//所属分组名字
     */
    private String catelogName;

    private String groupName;

    private Long[] catelogPath;
}
