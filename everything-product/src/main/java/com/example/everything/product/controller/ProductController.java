package com.example.everything.product.controller;

import com.example.everything.common.exception.BusinessException;
import com.example.everything.common.response.ObjectResponse;
import com.example.everything.common.response.ResponseUtils;
import com.example.everything.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author win10
 */
@RestController
@RequestMapping("api/v1/pro")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * list请求
     *
     * @param id
     * @return
     */
    @GetMapping("/list")
    public ObjectResponse selectToList(int id) throws BusinessException {
        System.out.println(id);
        if (id > 0 && id < 3) {
            throw new BusinessException(300, "sssssssBusinessExceptionsyyyyyyyuuuuuu");
        }
        if (id > 3) {
            return ResponseUtils.ok("没有查询到数据！");
        }
        if (id > 4) {
            return ResponseUtils.error("服务器异常");
        }
        return ResponseUtils.ok(id);
    }

    @GetMapping("/find")
    public ObjectResponse selectById(@RequestParam(value = "id") int id){
        String s = this.productService.selectById(id);
        return ResponseUtils.ok(s);
    }

    /**
     * 调用feign查询
     * @param id
     * @return
     */
    @GetMapping("/id")
    public ObjectResponse selectByList(@RequestParam(value = "id") int id){
        String s = this.productService.selectByList(id);
        return ResponseUtils.ok(s);
    }
}
