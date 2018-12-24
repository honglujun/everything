package com.example.everything.order.feign.fallback;

import com.example.everything.order.feign.ProductClient;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 * 针对商品服务，降级处理
 * @author win10
 */
@Log4j2
@Component
public class ProductClientFallback implements ProductClient {

    @Override
    public String selectById(int id) {
        log.info("===========>everything-product服务不可用，服务降级");
        return null;
    }
}
