package net.nanquanyuhao.paasdemo.elasticsearch.service.impl;

import net.nanquanyuhao.paasdemo.elasticsearch.dao.BookRepository;
import net.nanquanyuhao.paasdemo.elasticsearch.pojo.Book;
import net.nanquanyuhao.paasdemo.elasticsearch.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by nanquanyuhao on 2019/4/2.
 */
@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    @Qualifier("bookRepository")
    private BookRepository bookRepository;

    @Override
    public Optional<Book> findById(String id) {
        //CrudRepository中的方法
        return bookRepository.findById(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public Optional<Book> findOne(String id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Page<Book> findByAuthor(String author, PageRequest pageRequest) {
        return bookRepository.findByAuthor(author, pageRequest);
    }

    @Override
    public Page<Book> findByTitle(String title, PageRequest pageRequest) {
        return bookRepository.findByTitle(title, pageRequest);
    }
}
