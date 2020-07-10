package com.debug.kill.server.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Document(indexName = "kill_index", type = "kill", shards = 5, replicas = 1, indexStoreType = "fs", refreshInterval = "-1")
public class Article implements Serializable {
    private static final long serialVersionUID = 551589397625941750L;
    @Id
    private String id;
    private String title;
    private String content;
    private Long postTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getPostTime() {
        return postTime;
    }

    public void setPostTime(Long postTime) {
        this.postTime = postTime;
    }
}
