package com.picea.contoller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    private Logger logger = LoggerFactory.getLogger(PiceaServletContoller.class);

    @RequestMapping("/task")
    public String task(String name) throws Exception {
        logger.info("info级别日志：" + name);
        logger.debug("debug级别日志：" + name );
        logger.error("error级别日志：" + name);
        return "日志测试" + name;
    }
}
