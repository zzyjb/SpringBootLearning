package com.picea.contoller;

import com.picea.service.PiceaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    @RequestMapping("/task")
    public void task(HttpServletRequest request,
                     HttpServletResponse response) throws Exception {
        piceaService.task();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("这个是无返回的处理方法");
    }

    @RequestMapping("/asyncTask")
    public void asyncTask(HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        System.out.println("控制层线程:" + Thread.currentThread().getName());
        AsyncContext asyncContext = request.startAsync();
        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent asyncEvent) throws IOException {
                // 异步执行完毕时
                System.out.println("异步执行完毕");
            }

            @Override
            public void onTimeout(AsyncEvent asyncEvent) throws IOException {
                //异步线程执行超时
                System.out.println("异步线程执行超时");
            }

            @Override
            public void onError(AsyncEvent asyncEvent) throws IOException {
                //异步线程出错时
                System.out.println("异步线程出错");
            }

            @Override
            public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
                //异步线程开始时
                System.out.println("异步线程开始");
            }
        });
        asyncContext.setTimeout(3000);
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("异步执行线程:" + Thread.currentThread().getName());
                    String str = piceaService.task2();
                    Thread.sleep(1000);
                    asyncContext.getResponse().setCharacterEncoding("UTF-8");
                    asyncContext.getResponse().setContentType("text/html;charset=UTF-8");
                    asyncContext.getResponse().getWriter().println("这是【异步】的请求返回: " +str);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }catch (Exception e) {
                    e.printStackTrace();
                }
                //异步请求完成通知，所有任务完成了，才执行
                asyncContext.complete();
            }
        });
    }
}
