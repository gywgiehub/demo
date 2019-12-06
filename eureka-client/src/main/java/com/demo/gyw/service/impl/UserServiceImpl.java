package com.demo.gyw.service.impl;

import com.demo.gyw.base.Demo;
import com.demo.gyw.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public Demo addUser(Demo demo) {
        System.out.println("添加user");
        demo.setId(1L);
        demo.setName("西门吹雪");
        return demo;
    }
    @Override
    public Demo updateUser(Demo demo) {
        System.out.println("修改user");
        demo.setName("独孤求败");
        return demo;
    }
    @Override
    public void deleteUser(Long id) {
       System.out.println("删除user");
    }
}
