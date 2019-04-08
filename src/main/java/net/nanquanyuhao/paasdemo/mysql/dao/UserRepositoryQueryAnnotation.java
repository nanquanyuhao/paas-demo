package net.nanquanyuhao.paasdemo.mysql.dao;

import net.nanquanyuhao.paasdemo.mysql.pojo.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by nanquanyuhao on 2018/11/15.
 * <p>
 * Repository @Query
 */
public interface UserRepositoryQueryAnnotation extends Repository<User, Integer> {

    /**
     * 使用 HQL 据名字查询
     *
     * @param name
     * @return
     */
    @Query("from User where name = ?1")
    List<User> queryByNameUseHQL(String name);

    /**
     * 使用 SQL 据名字查询
     *
     * @param name
     * @return
     */
    @Query(value = "select * from t_user where name = ?", nativeQuery = true)
    List<User> queryByNameUseSQL(String name);

    /**
     * 执行更新操作，据主键更新名称
     *
     * @param name
     * @param id
     */
    @Query("update User set name  = ?1 where id  = ?2")
    @Modifying
    void updateUserNameById(String name, Integer id);
}
