package com.picea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * <p>异步服务，启动类需要使用@EnableAsync标签，表示开启异步服务<p>
 * @author jiangbing.yang
 * @date   2019/3/27 9:49
 * @params
 * @return
 * @throws
 */

@EnableAsync
@SpringBootApplication
public class SpringBootAsync1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAsync1Application.class, args);
    }

}
