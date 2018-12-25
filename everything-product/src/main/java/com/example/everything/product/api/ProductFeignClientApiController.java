package com.example.everything.product.api;

import com.example.everything.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 对外提供的feign的controller
 * @author win10
 */
@RestController
@RequestMapping("api/v1/pro")
public class ProductFeignClientApiController {

    @Autowired
    private ProductService productService;

    @GetMapping("/find")
    public String selectById(@RequestParam(value = "id") int id){
        String s = this.productService.selectById(id);
        return s;
    }
}
