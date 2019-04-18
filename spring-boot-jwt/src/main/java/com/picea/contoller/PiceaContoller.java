package com.picea.contoller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.picea.constant.ConstantKey;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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

    @RequestMapping("/login")
    public Object login(String name, String password) throws Exception {
        /**
         * 这里为了简单，就不验证用户名和密码的正确性了，实际验证跟其他的方式一样，
         *         就是比对一下输入的用户名密码跟数据的数据是否一样
         */
        String token = "";
        token = JWT.create()
                .withAudience(name)// 将 user id 保存到 token 里面
                .withExpiresAt(new Date(System.currentTimeMillis() + 2 * 60 * 1000))//定义token的有效期
                .sign(Algorithm.HMAC256(ConstantKey.PICEA_JWT_KEY));// 加密秘钥，也可以使用用户保持在数据库中的密码字符串
        return token;
    }

    @RequestMapping("/queryPicea")
    public String queryPicea()  {
        String ret = "通过验证";
        return ret;
    }
}
