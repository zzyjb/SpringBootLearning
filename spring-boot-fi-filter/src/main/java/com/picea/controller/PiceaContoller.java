package com.picea.controller;

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
public class PiceaContoller {

    @RequestMapping("/query")
    public void asyncTask() throws Exception {
        System.out.println("我是控制类里面的方法，我正在思考...............");
    }
}
