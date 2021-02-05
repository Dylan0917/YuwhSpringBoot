package org.yu.elasticsearchmodule.bean;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/2/4 19:24
 */
@Document(indexName = "book") //不加该注解index默认为类名
public class Book {
    private Integer id;
    private String bookName;
    private String author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
