package com.lanxum.springasyncdemo.dao;


import com.lanxum.springasyncdemo.domain.dto.SjUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by wangyang on 2017/5/17.
 */
@Mapper
public interface UserDao {


    SjUser findById(int id);

    SjUser sjUserLogin(Map param);

}
