package spring.cloud.ykf.eureka.provide.user.dao;

import spring.cloud.ykf.eureka.provide.user.vo.User;

import java.util.List;

public interface TestDao {


    public String getInfo();

    public User findById(int id);

    public List<User>findAll(User user);

    public Boolean update(User user);

    public Boolean save(User user);

    public Boolean delete(int id);



}
