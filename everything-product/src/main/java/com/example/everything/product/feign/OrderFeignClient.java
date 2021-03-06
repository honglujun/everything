package com.example.everything.product.feign;

import com.example.everything.product.feign.fallback.OrderFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author win10
 */
@FeignClient(name = "everything-order", fallback = OrderFeignClientFallback.class)
public interface OrderFeignClient {

    /**
     * 调用Product服务
     *
     * @param id
     * @return
     */
    @GetMapping("api/v1/order/ids")
    String selectByList(@RequestParam(value = "id") int id);
}
