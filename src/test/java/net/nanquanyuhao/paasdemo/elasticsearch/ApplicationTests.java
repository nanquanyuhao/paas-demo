package net.nanquanyuhao.paasdemo.elasticsearch;

import net.nanquanyuhao.paasdemo.elasticsearch.pojo.Book;
import net.nanquanyuhao.paasdemo.elasticsearch.service.BookService;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by nanquanyuhao on 2019/4/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private BookService bookService;

    @Test
    public void contextLoads() {
        Book book1 = new Book("1", "ES入门教程", "程裕强", new Date());
        System.out.println(book1);
        bookService.save(book1);

        Optional<Book> opt = bookService.findById("1");
        Book book2 = opt.get();
        System.out.println(book2);
    }

    @Test
    public void matchQueryAll() {
        SearchQuery searchQuery = new NativeSearchQuery(QueryBuilders.matchAllQuery());
        List<Book> books = elasticsearchTemplate.queryForList(searchQuery, Book.class);
        System.out.println(books.toString());
    }

}
