package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * ����
 * 
 * @author GHYANG
 * @email 58132971@qq.com
 * @date 2020-05-24 14:22:27
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
