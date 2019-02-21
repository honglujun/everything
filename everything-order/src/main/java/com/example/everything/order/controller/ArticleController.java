package com.example.everything.order.controller;

import com.example.everything.order.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试elasticsearch的赠删改查
 *
 * @author win10
 */
@RestController
@RequestMapping("/es/article")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    /**
     * 新增
     *
     * @param id
     * @return
     */
    @GetMapping("/save")
    public Object save(String id) {
        return this.articleService.save(id);
    }

    /**
     * 查询
     *
     * @param title
     * @return
     */
    @GetMapping("/search")
    public Object search(String title) {
        return this.articleService.search(title);
    }
}
