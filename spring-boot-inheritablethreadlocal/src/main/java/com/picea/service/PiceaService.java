package com.picea.service;

import java.util.concurrent.Future;

/**
 * <p>PiceaService</p>
 * <p>description.</p>
 *
 * @author : jiangbing.yang
 * @version 0.1
 * @date : 2019/3/26 15:45
 * @company :
 */

public interface PiceaService {
    //测试ThreadLocal方法
    String testThreadLocal() throws Exception;
    //测试ThreadLocal方法
    void testThreadLocalAsync() throws Exception;
    //测试ThreadLocal方法
    void testThreadLocalAsyncItl() throws Exception;
    //测试ThreadLocal方法
    void testThreadLocalAsyncThreadPool() throws Exception;
    //测试ThreadLocal方法
    void testThreadLocalAsyncThreadPoolTtl() throws Exception;

}
