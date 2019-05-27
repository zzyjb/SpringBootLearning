package com.picea.contoller;

import com.picea.service.PiceaService;
import com.picea.util.InheritableThreadLocalUtil;
import com.picea.util.ThreadLocalUtil;
import com.picea.util.TransmittableThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

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
public class PiceaContoller {

    @Autowired
    private PiceaService piceaService;

    @RequestMapping("/testTl")
    public String testThreadLocal() throws Exception {
        System.out.println("我是Controller层处理线程，线程名：" + Thread.currentThread().getName());
        ThreadLocalUtil.setValue("我是：testThreadLocal");
        System.out.println("这里是处理过程，处理中.........");
        System.out.println(" ThreadLocalUtil保存的值为：" + ThreadLocalUtil.getValue());
        String ret = piceaService.testThreadLocal();
        return "testThreadLocal:" + ret;
    }

    @RequestMapping("/testTlA")
    public String testThreadLocalAsync() throws Exception {
        System.out.println("我是Controller层处理线程，线程名：" + Thread.currentThread().getName());
        ThreadLocalUtil.setValue("我是：testThreadLocalAsync");
        System.out.println("这里是处理过程，处理中.........");
        System.out.println(" ThreadLocalUtil保存的值为：" + ThreadLocalUtil.getValue());
        piceaService.testThreadLocalAsync();
        return "testThreadLocalAsync:";
    }

    @RequestMapping("/testItl")
    public String testInheritableThreadLocal() throws Exception {
        System.out.println("我是Controller层处理线程，线程名：" + Thread.currentThread().getName());
        InheritableThreadLocalUtil.setValue("我是：testInheritableThreadLocal");
        System.out.println("这里是处理过程，处理中.........");
        System.out.println(" InheritableThreadLocalUtil保存的值为：" + InheritableThreadLocalUtil.getValue());
        piceaService.testThreadLocalAsyncItl();
        return "testInheritableThreadLocal:";
    }

    @RequestMapping("/testItlTl")
    public String testInheritableThreadLocalThreadPool() throws Exception {
        System.out.println("我是Controller层处理线程，线程名：" + Thread.currentThread().getName());
        InheritableThreadLocalUtil.setValue("我是：testInheritableThreadLocal");
        System.out.println("这里是处理过程，处理中.........");
        System.out.println(" InheritableThreadLocalUtil保存的值为：" + InheritableThreadLocalUtil.getValue());
        piceaService.testThreadLocalAsyncThreadPool();
        return "testInheritableThreadLocalThreadPool:";
    }

    @RequestMapping("/testTtlTl")
    public String testTransmittableThreadLocalThreadPool() throws Exception {
        System.out.println("我是Controller层处理线程，线程名：" + Thread.currentThread().getName());
        TransmittableThreadLocalUtil.setValue("我是：testTransmittableThreadLocalThreadPool");
        System.out.println("这里是处理过程，处理中.........");
        System.out.println(" TransmittableThreadLocalUtil保存的值为：" + TransmittableThreadLocalUtil.getValue());
        piceaService.testThreadLocalAsyncThreadPoolTtl();
        return "testInheritableThreadLocalThreadPool:";
    }
}
