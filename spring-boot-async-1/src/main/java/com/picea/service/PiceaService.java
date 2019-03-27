package com.picea.service;

import java.util.concurrent.Future;

/**
 * <p>PiceaService</p>
 * <p>description.</p>
 *
 * @author : jiangbing.yang
 * @version 0.1
 * @date : 2019/3/26 15:45
 * @company : 北京立思辰新技术有限公司
 */

public interface PiceaService {
    //无返回参数方法
    void asyncTask() throws Exception;
    //有返回参数方法
    Future<String> asyncTaskFuture() throws Exception;
    //有返回参数方法2
    Future<String> asyncTaskFuture2() throws Exception;
}
