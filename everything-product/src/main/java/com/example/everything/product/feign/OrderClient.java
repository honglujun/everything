package com.example.everything.product.feign;

import com.example.everything.product.feign.fallback.OrderClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author win10
 */
@FeignClient(name = "everything-order", fallback = OrderClientFallback.class)
public interface OrderClient {

    /**
     * 调用Product服务
     *
     * @param id
     * @return
     */
    @GetMapping("api/v1/order/ids")
    String selectByList(int id);
}
