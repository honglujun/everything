package com.example.everything.order.service.impl.chart;

import com.example.everything.order.model.domain.Article;
import com.example.everything.order.repository.ArticleRepository;
import com.example.everything.order.service.IArticleService;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author win10
 */
@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Object save(String str) {
        Article article = new Article();
        article.setContent("@author win10");
        article.setId(Long.valueOf(str));
        article.setPv(2);
        article.setSummary("搜索框架整合"+str);
        article.setTitle("这是一个测试类");
        return this.articleRepository.save(article);
    }

    @Override
    public Object search(String title) {
        QueryBuilder queryBuilder = QueryBuilders.matchAllQuery(); //搜索全部文档
//        QueryBuilder queryBuilder = QueryBuilders.matchQuery("title", title);
        return this.articleRepository.search(queryBuilder);
    }
}
