package com.atguigu.gulimall.ware.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * User: GHYANG
 * Date: 2020-06-04
 * Description:
 */
@Data
public class PurchaseDoneVo {
    @NotNull
    private Long id; //采购单id

    private List<PurchaseItemDoneVo> items;

}
