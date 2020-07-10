package com.debug.kill.server.controller;

import com.debug.kill.server.es.ArticleSearchRepository;
import com.debug.kill.server.model.Article;
import com.github.pagehelper.StringUtil;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/es")
public class EsController {

    @Autowired
    private ArticleSearchRepository repository;

    @RequestMapping("/el")
    public Page<Article> searchEs(String content) {
        //检索条件
        BoolQueryBuilder bqb = QueryBuilders.boolQuery();
        if (StringUtil.isNotEmpty(content))
            bqb.must(QueryBuilders.matchPhraseQuery("content", content));
        //构建查询
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withIndices("kill_index")//索引名
                .withTypes("kill")//类型名
                .withQuery(bqb)// 查询条件对象
                .withPageable(PageRequest.of(0, 1000))//从0页开始查，每页1000个结果
                .build();
        Page<Article> search = repository.search(searchQuery);
        return search;
    }

    @RequestMapping("/save")
    public void save(String nm, String content) {
        DateFormat pdfDate = new SimpleDateFormat("yyyyMMddHHmmss");
        String pdfDateString = pdfDate.format(new Date());
        Article article = new Article();
        article.setId(pdfDateString);
        article.setContent(nm + "," + content + "," + nm + "," + content + "," + nm + "," + content + "," + nm);
        this.repository.save(article);
    }


}
