package net.nanquanyuhao.paasdemo.mysql;

import net.nanquanyuhao.paasdemo.PaasDemoApplication;
import net.nanquanyuhao.paasdemo.mysql.dao.UserRepository;
import net.nanquanyuhao.paasdemo.mysql.pojo.Role;
import net.nanquanyuhao.paasdemo.mysql.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * Created by nanquanyuhao on 2018/11/16.
 * <p>
 * 一对多关联关系测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {PaasDemoApplication.class})
public class OneToManyTest {

    @Autowired
    private UserRepository userRepository;

    /**
     * 一对多广联关系的添加
     */
    @Test
    public void testSave() {
        // 创建一个用户
        User user = new User();
        user.setAddress("天津");
        user.setAge(32);
        user.setName("小刚");

        // 创建一个角色
        Role role = new Role();
        role.setRoleName("管理员");

        // 关联
        role.getUsers().add(user);
        user.setRole(role);

        // 保存
        this.userRepository.save(user);
    }

    /**
     * 一对多广联关系的查询
     */
    @Test
    public void testFind(){
        Optional<User> optional = this.userRepository.findById(4);
        System.out.println(optional.get());

        Role role = optional.get().getRole();
        System.out.println(role.getRoleName());
    }
}
