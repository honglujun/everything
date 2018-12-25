package com.example.everything.order.service.impl;


import com.example.everything.order.feign.ProductFeignClient;
import com.example.everything.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author win10
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductFeignClient productFeignClient;

    /**
     * 通过feign调用product的服务
     *
     * @param id
     * @return
     */
    @Override
    public String selectById(int id) {
        return this.productFeignClient.selectById(id);
    }

    /**
     * 查询测试
     *
     * @param id
     * @return
     */
    @Override
    public String selectByList(int id) {
        if (id == 2) {
            return "2";
        }
        return "other order";
    }
}
