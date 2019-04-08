package net.nanquanyuhao.paasdemo.redis.dao.impl;

import net.nanquanyuhao.paasdemo.redis.dao.PersonRepoCustom;
import net.nanquanyuhao.paasdemo.redis.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author liyh1928
 * @date 2019/4/8
 */
public class PersonRepoImpl implements PersonRepoCustom {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public List<Person> myQuery() {

        List<Person> datas = stringRedisTemplate.execute(new RedisCallback<List<Person>>() {
            @Nullable
            @Override
            public List<Person> doInRedis(RedisConnection redisConnection) throws DataAccessException {

                List<Person> result = new ArrayList<>();
                // key 都是以 set 类型保存的，先查询到全部的 key
                Set<byte[]> dataKeys = redisConnection.sMembers("Person".getBytes());
                // 根据每个 key 去查询数据
                for (byte[] dataKey : dataKeys) {
                    // 数据是以 hash 类型保存的，key 使用以下格式：“Person:UUID”
                    String dataKeyStr = "Person:" + new String(dataKey);
                    Map<byte[], byte[]> data = redisConnection.hGetAll(dataKeyStr.getBytes());

                    // 读取数据，并转换为 Person
                    String age = new String(data.get("age".getBytes()));
                    String name = new String(data.get("name".getBytes()));
                    String company = new String(data.get("company".getBytes()));
                    String id = new String(data.get("id".getBytes()));
                    Person p = new Person();
                    p.setId(id);
                    p.setAge(Integer.parseInt(age));
                    p.setName(name);
                    p.setCompany(company);
                    result.add(p);
                }

                return result;
            }
        });

        return datas;
    }
}
