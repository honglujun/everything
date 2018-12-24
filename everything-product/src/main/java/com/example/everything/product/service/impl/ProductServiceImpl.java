package com.example.everything.product.service.impl;


import com.example.everything.product.feign.OrderClient;
import com.example.everything.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author win10
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private OrderClient orderClient;

    /**
     * 通过id查询书据
     *
     * @param id
     * @return
     */
    @Override
    public String selectById(int id) {
        if (id == 3) {
            return "3";
        } else {
            return "other product";
        }
    }

    @Override
    public String selectByList(int id) {

        return this.orderClient.selectByList(id);
    }
}
