package com.atguigu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ���Է���
 * 
 * @author GHYANG
 * @email 58132971@qq.com
 * @date 2020-05-24 09:08:51
 */
@Data
@TableName("pms_attr_group")
public class AttrGroupEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ����id
	 */
	@TableId
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

	@TableField(exist = false)
	private Long[] catelogPath;

}
