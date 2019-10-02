package com.example.everything.order.model.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @author win10
 */
@Setter
@Getter
@Document(indexName = "database", type = "tableName")
public class Article implements Serializable {

    private static final long serialVersionUID = -2169437204303938189L;

    private long id;

    private String title;

    private String summary;

    private String content;

    private int pv;

}
