package com.lanxum.springasyncdemo.contoller;

import com.lanxum.springasyncdemo.dao.UserDao;
import com.lanxum.springasyncdemo.domain.dto.SjUser;
import com.lanxum.springasyncdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * <p>TestContoller</p>
 * <p>description.</p>
 *
 * @author : jiangbing.yang
 * @version 0.1
 * @date : 2019/3/20 15:57
 * @company : 北京立思辰新技术有限公司
 */

@RestController
@RequestMapping(value = "/test")
public class UserContoller {

    private static final Logger logger = LoggerFactory.getLogger(UserContoller.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;


    @RequestMapping(value = "/testAsync",method = RequestMethod.GET)
    public SjUser print() throws ExecutionException, InterruptedException, TimeoutException {
        System.out.println("ThreadName = " + Thread.currentThread().getName());
        System.out.println("测试线程开始");
        Future<SjUser> future = userService.findUserById(1);
        SjUser retSjUser = future.get(60,TimeUnit.MILLISECONDS);
//        while (true) {
//            if (future.isDone()) {
//                System.out.println("Result from asynchronous process - " + future.get());
//                retSjUser = future.get();
//                break;
//            }
//        }
//        System.out.println("测试完毕.........................");
        return retSjUser;
    }

}
