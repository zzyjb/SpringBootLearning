package com.picea.contoller;

import com.picea.service.PiceaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;

/**
 * <p>PiceaContoller</p>
 * <p>description.</p>
 *
 * @author : jiangbing.yang
 * @version 0.1
 * @date : 2019/3/26 15:40
 * @company :
 */
@RestController
public class PiceaServletContoller {

    @Autowired
    private PiceaService piceaService;

    @RequestMapping("/webAsyncTask")
    public WebAsyncTask<String> deferredResult() throws Exception {
        System.out.println("控制层执行线程:" + Thread.currentThread().getName());
        WebAsyncTask<String> result = new WebAsyncTask<String>(10 * 1000L, new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("异步执行线程:" + Thread.currentThread().getName());
                String str = piceaService.task2();
                Thread.sleep(1000);
                return ("这是【异步】的请求返回: " + str);
            }
        });
        //定义超时
        result.onTimeout(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("异步线程执行超时");
                return ("线程执行超时");
            }
        });
        //定义完成,即使是超时，也会运行此方法
        result.onCompletion(new Runnable() {
            @Override
            public void run() {
                System.out.println("异步执行完毕");
            }
        });
        return result;
    }
}
