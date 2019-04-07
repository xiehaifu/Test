package spring.cloud.ykf.eureka.provide.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.cloud.ykf.eureka.provide.user.dao.TestDao;
import spring.cloud.ykf.eureka.provide.user.service.Testservice;
import spring.cloud.ykf.eureka.provide.user.vo.User;

@Service
public class TestserviceImpl implements Testservice {
    @Autowired
    TestDao testDao ;
    @Override
    public String getS(int findById) {
        User info = testDao.findById(findById);
        return info.getName();
    }
}
