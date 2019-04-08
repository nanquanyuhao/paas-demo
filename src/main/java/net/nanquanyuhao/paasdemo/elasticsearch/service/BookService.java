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

    /**
     * 通过主键查询
     * @param id
     * @return
     */
    Optional<Book> findById(String id);

    /**
     * 保存方法
     * @param book
     * @return
     */
    Book save(Book book);

    /**
     * 删除方法
     * @param book
     */
    void delete(Book book);

    /**
     * 依据主键查找
     * @param id
     * @return
     */
    Optional<Book> findOne(String id);

    /**
     * 查询全部
     * @return
     */
    List<Book> findAll();

    /**
     * 根据作者分页查询
     * @param author
     * @param pageRequest
     * @return
     */
    Page<Book> findByAuthor(String author, PageRequest pageRequest);

    /**
     * 根据标题分页查询
     * @param title
     * @param pageRequest
     * @return
     */
    Page<Book> findByTitle(String title, PageRequest pageRequest);
}
