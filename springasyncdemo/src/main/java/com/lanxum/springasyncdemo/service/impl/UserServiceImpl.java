package com.lanxum.springasyncdemo.service.impl;

import com.lanxum.springasyncdemo.dao.UserDao;
import com.lanxum.springasyncdemo.domain.dto.SjUser;
import com.lanxum.springasyncdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * <p>UserServiceImpl</p>
 * <p>description.</p>
 *
 * @author : jiangbing.yang
 * @version 0.1
 * @date : 2019/3/20 15:54
 * @company : 北京立思辰新技术有限公司
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public Future<SjUser> findUserById(int num) {
        System.out.println("ThreadName:" + Thread.currentThread().getName());
        SjUser sjUser = userDao.findById(num);
        return new AsyncResult<SjUser>(sjUser);
    }

    @Override
    @Async("taskExecutor")
    public Future<String> testV(String name) {
        System.out.println("ThreadName:" + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            String ret = name + "我是第2个接口：testV";
            return new AsyncResult<String>(ret);
        }catch (InterruptedException  e) {
            e.printStackTrace();
        }
        System.out.println("测试Spring 异步调用！");
        return null;
    }
}
