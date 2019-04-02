package net.nanquanyuhao.paasdemo.mysql.dao;

import net.nanquanyuhao.paasdemo.mysql.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nanquanyuhao on 2018/11/15.
 * <p>
 * 参数一 T：当前需要映射的实体
 * 参数二 ID：当前映射的是实体中的 OID 的类型
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
