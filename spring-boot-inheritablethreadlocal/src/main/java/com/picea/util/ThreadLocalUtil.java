package com.picea.util;

/**
 * <p>ThreadLocalUtil</p>
 * <p>description.</p>
 *
 * @author : jiangbing.yang
 * @version 0.1
 * @date : 2019/5/27 14:41
 * @company :
 */

public class ThreadLocalUtil {

    public static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    //设置线程需要保存的值
    public static void setValue (String str) {
        THREAD_LOCAL.set(str);
    }

    //获取线程中保存的值
    public static String getValue() {
        return THREAD_LOCAL.get();
    }

    //移除线程中保存的值
    public static void remove() {
        THREAD_LOCAL.remove();
    }
}
