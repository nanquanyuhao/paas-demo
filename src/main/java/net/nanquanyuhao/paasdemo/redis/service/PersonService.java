package net.nanquanyuhao.paasdemo.redis.service;

import net.nanquanyuhao.paasdemo.redis.dao.PersonRepo;
import net.nanquanyuhao.paasdemo.redis.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author liyh1928
 * @date 2019/4/8
 */
@Service("RedisPersonService")
public class PersonService {

    @Autowired
    private PersonRepo personRepo;

    /**
     * 获取全部实体集合
     *
     * @return
     */
    public List<Person> getPersons() {

        Iterable<Person> persons = personRepo.findAll();
        List<Person> datas = new ArrayList<>();
        for (Iterator<Person> it = persons.iterator(); it.hasNext(); ) {
            Person p = it.next();
            datas.add(p);
        }

        return datas;
    }

    /**
     * 据名称查询实例
     *
     * @param name
     * @return
     */
    public List<Person> getPersonsByName(String name) {
        return personRepo.findByName(name);
    }

    /**
     * 自定义接口查询
     *
     * @return
     */
    public List<Person> getPersonsByCustom() {
        return personRepo.myQuery();
    }

    /**
     * 按名称创建实体
     *
     * @param name
     */
    public void save(String name) {
        Person p = new Person();
        p.setName(name);
        p.setAge(33);
        p.setCompany("山东");
        personRepo.save(p);
    }
}
