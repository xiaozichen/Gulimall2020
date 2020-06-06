package com.atguigu.gulimall.product.vo;

import com.atguigu.gulimall.product.entity.AttrEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * User: GHYANG
 * Date: 2020-06-02
 * Description:
 */
@Data
public class AttrGroupWithAttrsVo {

    /**
     * ����id
     */
    private Long attrGroupId;
    /**
     * ����
     */
    private String attrGroupName;
    /**
     * ����
     */
    private Integer sort;
    /**
     * ����
     */
    private String descript;
    /**
     * ��ͼ��
     */
    private String icon;
    /**
     * �������id
     */
    private Long catelogId;

    private List<AttrEntity> attrs;
}
