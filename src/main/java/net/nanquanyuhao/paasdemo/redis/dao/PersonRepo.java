package net.nanquanyuhao.paasdemo.redis.dao;

import net.nanquanyuhao.paasdemo.redis.pojo.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * @author liyh1928
 * @date 2019/4/8
 */
public interface PersonRepo extends CrudRepository<Person, String>, PersonRepoCustom {
}
