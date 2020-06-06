package com.atguigu.gulimall.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * �ֿ���Ϣ
 * 
 * @author GHYANG
 * @email 58132971@qq.com
 * @date 2020-05-24 14:26:51
 */
@Data
@TableName("wms_ware_info")
public class WareInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * �ֿ���
	 */
	private String name;
	/**
	 * �ֿ��ַ
	 */
	private String address;
	/**
	 * �������
	 */
	private String areacode;

}
