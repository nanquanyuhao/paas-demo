package net.nanquanyuhao.paasdemo.mysql.dao;

import net.nanquanyuhao.paasdemo.mysql.pojo.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by nanquanyuhao on 2018/11/15.
 */
public interface UserRepositoryCrudRepository extends CrudRepository<User, Integer> {

}
