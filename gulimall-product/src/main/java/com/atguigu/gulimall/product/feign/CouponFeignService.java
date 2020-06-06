package com.atguigu.gulimall.product.feign;

import com.atguigu.common.to.SkuReductionTo;
import com.atguigu.common.to.SpuBoundTo;
import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created with IntelliJ IDEA
 * User: GHYANG
 * Date: 2020-06-03
 * Description:
 *  1-CouponFeignService.saveSpuBounds(spuBoundTo);
 *      1--@RquestBoudy将这个对象转为json
 *      2--找到gulimall-coupon服务,给/coupon/spubounds/save发送请求
 *          将上一步转的收到请求。请求体里有json数据
 *      3--对方服务收到请求，请求体里有json数据
 *          （@RequestBody SpuBoundsEntity spuBounds);将请求体的json转为SpuBoundsEntity；
 *  总结：只要json数据模型是兼容的。双方服务无需使用同一个to
 */
@FeignClient("gulimall-coupon")
public interface CouponFeignService {
    /**
     * 1-
     * @param spuBoundTo
     * @return
     */
    @PostMapping("/coupon/spubounds/save")
    R saveSpuBounds(@RequestBody SpuBoundTo spuBoundTo);

    @PostMapping("/coupon/skufullreduction/saveinfo")
    R saveSkuReduction(@RequestBody SkuReductionTo skuReductionTo);
}
