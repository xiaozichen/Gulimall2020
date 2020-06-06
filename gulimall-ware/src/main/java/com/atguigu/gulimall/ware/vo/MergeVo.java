package com.atguigu.gulimall.ware.vo;

import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * User: GHYANG
 * Date: 2020-06-04
 * Description:
 */
@Data
public class MergeVo {
    private Long purchaseId; //整单id
    private List<Long> items; //[1,2,3,4] //合并项集合

}
