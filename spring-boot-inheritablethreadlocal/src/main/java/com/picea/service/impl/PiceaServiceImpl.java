package com.picea.service.impl;

import com.picea.service.PiceaService;
import com.picea.util.InheritableThreadLocalUtil;
import com.picea.util.ThreadLocalUtil;
import com.picea.util.TransmittableThreadLocalUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * <p>PiceaServiceImpl</p>
 * <p>description.</p>
 *
 * @author : jiangbing.yang
 * @version 0.1
 * @date : 2019/3/26 15:45
 * @company :
 */

@Service
public class PiceaServiceImpl implements PiceaService {
    @Override
    public String testThreadLocal() throws Exception {
        System.out.println("我是Service层处理线程，线程名：" + Thread.currentThread().getName());
        System.out.println(" ThreadLocalUtil保存的值为：" + ThreadLocalUtil.getValue());
        ThreadLocalUtil.remove();
        return "sss";
    }

    @Async
    @Override
    public void testThreadLocalAsync() throws Exception {
        System.out.println("我是Service层处理线程，线程名：" + Thread.currentThread().getName());
        System.out.println(" ThreadLocalUtil保存的值为：" + ThreadLocalUtil.getValue());
        ThreadLocalUtil.remove();
    }

    @Async
    @Override
    public void testThreadLocalAsyncItl() throws Exception {
        System.out.println("我是Service层处理线程，线程名：" + Thread.currentThread().getName());
        System.out.println(" InheritableThreadLocalUtil保存的值为：" + InheritableThreadLocalUtil.getValue());
        InheritableThreadLocalUtil.remove();
    }

    @Async("piceaTaskExecutor")
    @Override
    public void testThreadLocalAsyncThreadPool() throws Exception {
        System.out.println("我是Service层处理线程，线程名：" + Thread.currentThread().getName());
        System.out.println(" InheritableThreadLocalUtil保存的值为：" + InheritableThreadLocalUtil.getValue());
        InheritableThreadLocalUtil.remove();
    }

    @Async("piceaTaskExecutor")
    @Override
    public void testThreadLocalAsyncThreadPoolTtl() throws Exception {
        System.out.println("我是Service层处理线程，线程名：" + Thread.currentThread().getName());
        System.out.println(" TransmittableThreadLocalUtil：" + TransmittableThreadLocalUtil.getValue());
        TransmittableThreadLocalUtil.remove();
    }

}
