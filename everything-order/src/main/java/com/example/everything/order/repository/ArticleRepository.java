package com.example.everything.order.repository;

import com.example.everything.order.model.domain.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * 继承ElasticsearchRepository的赠删改查的接口
 *
 * @author win10
 */
@Component
//@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {

}
