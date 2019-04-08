package net.nanquanyuhao.paasdemo.redis.dao;

import net.nanquanyuhao.paasdemo.redis.pojo.Person;

import java.util.List;

/**
 * @author liyh1928
 * @date 2019/4/8
 */
public interface PersonRepoCustom {

    /**
     * 自定义查询
     *
     * @return
     */
    List<Person> myQuery();
}
