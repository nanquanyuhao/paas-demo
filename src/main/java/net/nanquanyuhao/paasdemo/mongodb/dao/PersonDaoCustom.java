package net.nanquanyuhao.paasdemo.mongodb.dao;

import net.nanquanyuhao.paasdemo.mongodb.pojo.Person;

import java.util.List;

/**
 * Created by nanquanyuhao on 2017/11/26.
 */
public interface PersonDaoCustom {

    /**
     * 实现自己查询逻辑想查全部的
     *
     * @return
     */
    List<Person> myQuery();
}
