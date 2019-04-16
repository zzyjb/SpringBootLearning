package com.picea.springbootlog4jasync;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootLog4jAsyncApplicationTests {

    private static final Logger logger = LogManager.getLogger(SpringBootLog4jAsyncApplicationTests.class);

    @Test
    public void contextLoads() {
        String name = "log4j2Async";
        Long startTime = System.currentTimeMillis();
        for (int i =0 ;i <10000; i++){
            logger.info("info级别日志：{}" ,name);
            logger.warn("warn级别日志：{}" ,name );
            logger.error("error级别日志：{}" ,name);
        }
        System.out.println("----------------------------------------------------------------------");
        System.out.println("花费的时间为：" + (System.currentTimeMillis()-startTime) );
    }

}
