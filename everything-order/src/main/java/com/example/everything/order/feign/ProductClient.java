package com.example.everything.order.feign;

import com.example.everything.order.feign.fallback.ProductClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author win10
 */
@FeignClient(name = "everything-product" , fallback = ProductClientFallback.class)
public interface ProductClient {
    /**
     * 通过id查询数据
     * @param id
     * @return
     */
    @GetMapping("/api/v1/pro/find")
    String selectById(@RequestParam(value = "id") int id);
}
