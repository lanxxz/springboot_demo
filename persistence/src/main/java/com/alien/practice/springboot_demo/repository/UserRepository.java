package com.alien.practice.springboot_demo.repository;

import com.alien.practice.springboot_demo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link User} {@link Repository}
 * @author Alien
 * @date 2019.03.07
 */
@Repository
public class UserRepository {

    /**
     * 保存记录的对象{@link User}
     */
    private final ConcurrentMap<Integer, User> repository = new ConcurrentHashMap<>();

    /**
     * 自增id
     */
    private final static AtomicInteger idGenerator = new AtomicInteger();

    /**
     * 保存用户
     * @param user {@link User} 对象
     * @return 如果保存成功，返回<code>true</code>,否则返回<code>false</code>
     */
    public boolean save(User user) {
        //从1开始自增
        Integer id = idGenerator.incrementAndGet();
        user.setId(id);
        return repository.put(id, user) == null;
    }

    public Collection<User> findAll() {
//        List<User> list = new ArrayList<>();
//        for (Map.Entry<Integer, User> entry: repository.entrySet()) {
//            list.add(entry.getValue());
//        }
//        return  list;
        return repository.values();
    }
}
