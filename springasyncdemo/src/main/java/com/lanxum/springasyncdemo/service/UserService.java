package com.lanxum.springasyncdemo.service;


import com.lanxum.springasyncdemo.domain.dto.SjUser;

import java.util.concurrent.Future;

public interface UserService {

    Future<SjUser> findUserById(int num);

    Future<String> testV(String name);
}
