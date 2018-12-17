package com.example.everything.order.controller;

import com.example.everything.common.exception.BusinessException;
import com.example.everything.common.response.ObjectResponse;
import com.example.everything.common.response.ResponseUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author win10
 */
@RestController
@RequestMapping("api/v1/pro")
public class OrderController {

    /**
     * list请求
     * @param id
     * @return
     */
    @GetMapping("/list")
    public ObjectResponse selectToList(int id) throws BusinessException {
        System.out.println(id);
        if(id>0&&id<3){
            throw new BusinessException(300,"sssssssBusinessExceptionsyyyyyyyuuuuuu");
        }
        if(id>3){
            return ResponseUtils.ok("没有查询到数据！");
        }
        if(id>4){
            return ResponseUtils.error("服务器异常");
        }
       return ResponseUtils.ok(id);
    }

}
