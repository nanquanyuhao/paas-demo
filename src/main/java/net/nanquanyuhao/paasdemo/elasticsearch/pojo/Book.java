package net.nanquanyuhao.paasdemo.elasticsearch.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * Created by nanquanyuhao on 2019/4/2.
 */
@Document(indexName = "book", type = "_doc")
public class Book {

    @Id
    private String id;
    private String title;
    private String author;

    private Date postDate;

    public Book() {

    }

    public Book(String id, String title, String author, Date postDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.postDate = postDate;
    }

    @Override
    public String toString() {
        return "Book{" + "id='" + id + '\'' + ", title='" + title + '\'' + ", author='" + author + '\'' + ", postDate='" + postDate + '\'' + '}';
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }
}
