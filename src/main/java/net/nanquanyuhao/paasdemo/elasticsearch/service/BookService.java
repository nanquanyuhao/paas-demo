package net.nanquanyuhao.paasdemo.elasticsearch.service;

import net.nanquanyuhao.paasdemo.elasticsearch.pojo.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by nanquanyuhao on 2019/4/2.
 */
public interface BookService {

    Optional<Book> findById(String id);

    Book save(Book book);

    void delete(Book book);

    Optional<Book> findOne(String id);

    List<Book> findAll();

    Page<Book> findByAuthor(String author, PageRequest pageRequest);

    Page<Book> findByTitle(String title, PageRequest pageRequest);
}
