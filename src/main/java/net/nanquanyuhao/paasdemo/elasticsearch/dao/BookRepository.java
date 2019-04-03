package net.nanquanyuhao.paasdemo.elasticsearch.dao;

import net.nanquanyuhao.paasdemo.elasticsearch.pojo.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by nanquanyuhao on 2019/4/2.
 */
public interface BookRepository extends ElasticsearchRepository<Book, String> {

    Page<Book> findByAuthor(String author, Pageable pageable);

    Page<Book> findByTitle(String title, Pageable pageable);
}
