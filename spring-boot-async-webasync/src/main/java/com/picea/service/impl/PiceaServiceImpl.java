package com.picea.service.impl;

import com.picea.service.PiceaService;
import org.springframework.stereotype.Service;

/**
 * <p>PiceaServiceImpl</p>
 * <p>description.</p>
 *
 * @author : jiangbing.yang
 * @version 0.1
 * @date : 2019/3/28 15:45
 * @company :
 */

@Service
public class PiceaServiceImpl implements PiceaService {

    @Override
    public void task() throws Exception {
        System.out.println("------------------------在看貂蝉，不要打扰--------------");
        Thread.sleep(1000);
    }

    @Override
    public String task2 () throws Exception {
        int k = 5;
        System.out.println("------------------------在看鱼，不要打扰--------------");
        Thread.sleep(1000);
        return (String.valueOf(k));
    }
}
