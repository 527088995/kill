package com.debug.kill.server.es;


import com.debug.kill.server.model.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleSearchRepository extends ElasticsearchRepository<Article, String> {


}