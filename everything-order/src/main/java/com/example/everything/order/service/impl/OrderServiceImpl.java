package com.example.everything.order.service.impl;


import com.example.everything.order.feign.ProductClient;
import com.example.everything.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author win10
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductClient productClient;

    /**
     * 通过feign调用别的服务
     *
     * @param id
     * @return
     */
    @Override
    public String selectById(int id) {
        return this.productClient.selectById(id);
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
