package net.nanquanyuhao.paasdemo.mongodb.dao.impl;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import net.nanquanyuhao.paasdemo.mongodb.dao.PersonDaoCustom;
import net.nanquanyuhao.paasdemo.mongodb.pojo.Person;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.CollectionCallback;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义的查询方法
 * Created by nanquanyuhao on 2017/11/26.
 */
public class PersonDaoImpl implements PersonDaoCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Person> myQuery() {

        return mongoTemplate.execute(Person.class, new CollectionCallback<List<Person>>() {

            @Nullable
            @Override
            public List<Person> doInCollection(MongoCollection mongoCollection) throws MongoException, DataAccessException {

                MongoCursor<Document> mongoCursor = mongoCollection.find().iterator();
                List<Person> result = new ArrayList<>();
                while (mongoCursor.hasNext()) {
                    Document document = mongoCursor.next();

                    Person p = new Person();
                    ObjectId objectId = (ObjectId) document.get("_id");
                    p.setId(objectId.toHexString());
                    p.setAge((Integer) document.get("age"));
                    p.setName((String) document.get("name"));
                    p.setCompany((String) document.get("company"));

                    result.add(p);
                }

                return result;
            }
        });
    }
}
