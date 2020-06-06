package com.atguigu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.Data;

/**
 * ��Ʒ��������
 * 
 * @author GHYANG
 * @email 58132971@qq.com
 * @date 2020-05-24 09:08:51
 */
@Data
@TableName("pms_category")
public class CategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ����id
	 */
	@TableId
	private Long catId;
	/**
	 * ��������
	 */
	private String name;
	/**
	 * ������id
	 */
	private Long parentCid;
	/**
	 * �㼶
	 */
	private Integer catLevel;
	/**
	 * �Ƿ���ʾ[0-����ʾ��1��ʾ]
	 */
	@TableLogic(value = "1",delval = "0")  //设置逻辑删除--1显示/0不显示
	private Integer showStatus;
	/**
	 * ����
	 */
	private Integer sort;
	/**
	 * ͼ���ַ
	 */
	private String icon;
	/**
	 * ������λ
	 */
	private String productUnit;
	/**
	 * ��Ʒ����
	 */
	private Integer productCount;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@TableField(exist=false)
	private List<CategoryEntity> children;

}
