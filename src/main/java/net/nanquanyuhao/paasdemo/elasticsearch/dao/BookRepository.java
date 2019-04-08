package net.nanquanyuhao.paasdemo.elasticsearch.dao;

import net.nanquanyuhao.paasdemo.elasticsearch.pojo.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by nanquanyuhao on 2019/4/2.
 */
public interface BookRepository extends ElasticsearchRepository<Book, String> {

    /**
     * 通过作者分页查询
     *
     * @param author
     * @param pageable
     * @return
     */
    Page<Book> findByAuthor(String author, Pageable pageable);

    /**
     * 通过标题分页查询
     *
     * @param title
     * @param pageable
     * @return
     */
    Page<Book> findByTitle(String title, Pageable pageable);
}
