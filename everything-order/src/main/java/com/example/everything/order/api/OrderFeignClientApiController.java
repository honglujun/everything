package com.example.everything.order.api;

import com.example.everything.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 对外提供的feign的controller
 * @author win10
 */
@RestController
@RequestMapping("api/v1/order")
public class OrderFeignClientApiController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/ids")
    public String selectByList(int id){
        String s = this.orderService.selectByList(id);
        return s;
    }
}
