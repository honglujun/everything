package com.example.everything.product.feign.fallback;

import com.example.everything.product.feign.OrderClient;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 * @author win10
 */
@Log4j2
@Component
public class OrderClientFallback implements OrderClient {
    @Override
    public String selectByList(int id) {
        log.info("===========>everything-order服务不可用，服务降级");
        return null;
    }
}
