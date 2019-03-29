package com.picea.contoller;

import com.picea.service.PiceaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    @RequestMapping("/deferredresult")
    public DeferredResult<String> deferredResult() throws Exception {
        System.out.println("控制层执行线程:" + Thread.currentThread().getName());

        //超时
        DeferredResult<String> deferredResult = new DeferredResult<String>(10*1000L);
        deferredResult.onTimeout(new Runnable() {
            @Override
            public void run() {
                System.out.println("异步线程执行超时");
                deferredResult.setResult("线程执行超时");
            }
        });
        deferredResult.onCompletion(new Runnable() {
            @Override
            public void run() {
                System.out.println("异步执行完毕");
            }
        });
        FIXED_THREAD_POOL.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("异步执行线程:" + Thread.currentThread().getName());
                try {
                    String str = piceaService.task2();
                    Thread.sleep(1000);
                    deferredResult.setResult("这是【异步】的请求返回: " + str);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        return deferredResult;
    }

    /**
     * 线程池
     */
    public static ExecutorService FIXED_THREAD_POOL = Executors.newFixedThreadPool(10);
}
