package net.nanquanyuhao.paasdemo.mongodb.service;

import net.nanquanyuhao.paasdemo.mongodb.dao.PersonDao;
import net.nanquanyuhao.paasdemo.mongodb.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nanquanyuhao on 2017/11/26.
 */
@Service("MongoPersonService")
public class PersonService {

    @Autowired
    private PersonDao personDao;

    public List<Person> findAll() {
        return personDao.findAll();
    }

    public Person save(Person p) {
        return personDao.save(p);
    }

    public List<Person> myQuery() {
        return personDao.myQuery();
    }

    public List<Person> findByNameAndAge(String name, int age) {
        return personDao.findByNameAndAge(name, age);
    }
}
