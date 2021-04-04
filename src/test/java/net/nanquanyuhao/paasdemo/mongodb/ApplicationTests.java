package net.nanquanyuhao.paasdemo.mongodb;

import net.nanquanyuhao.paasdemo.mongodb.pojo.Person;
import net.nanquanyuhao.paasdemo.mongodb.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by nanquanyuhao on 2019/4/3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    @Qualifier("MongoPersonService")
    private PersonService personService;

    @Test
    public void contextAddLoads() {
        Person p = new Person();
        p.setAge(30);
        p.setCompany("产互公司山东");
        p.setName("人员甲");
        personService.save(p);
    }

    @Test
    public void contextLoads() {
        List<Person> list = personService.findAll();
        System.out.println(list);

        List<Person> list2 = personService.myQuery();
        System.out.println(list2);

        List<Person> list3 = personService.findByNameAndAge("人员甲", 12);
        System.out.println(list3);
    }
}
