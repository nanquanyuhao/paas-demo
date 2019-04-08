package net.nanquanyuhao.paasdemo.redis.dao;

import net.nanquanyuhao.paasdemo.redis.pojo.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author liyh1928
 * @date 2019/4/8
 */
public interface PersonRepo extends CrudRepository<Person, String>, PersonRepoCustom {

    /**
     * 通过名称进行精确查询
     *
     * @return
     */
    List<Person> findByName(String name);
}
