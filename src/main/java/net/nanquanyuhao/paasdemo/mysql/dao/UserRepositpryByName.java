package net.nanquanyuhao.paasdemo.mysql.dao;

import net.nanquanyuhao.paasdemo.mysql.pojo.User;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by nanquanyuhao on 2018/11/15.
 * <p>
 * Repository 接口的方法名称命名查询
 */
public interface UserRepositpryByName extends Repository<User, Integer> {

    // 方法的名称必须要遵循驼峰是命名规则。findBy（关键字） + 属性名称（首字母要大写） + 查询条件（首字母要大写）
    /**
     * 据名称查询
     *
     * @param name
     * @return
     */
    List<User> findByName(String name);

    /**
     * 据名称与年龄查询
     *
     * @param name
     * @param age
     * @return
     */
    List<User> findByNameAndAge(String name, Integer age);

    /**
     * 据名称模糊查询
     *
     * @param name
     * @return
     */
    List<User> findByNameLike(String name);
}
