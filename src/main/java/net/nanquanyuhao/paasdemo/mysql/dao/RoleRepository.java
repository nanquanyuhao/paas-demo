package net.nanquanyuhao.paasdemo.mysql.dao;

import net.nanquanyuhao.paasdemo.mysql.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nanquanyuhao on 2018/11/16.
 * <p>
 * RoleRepository
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
