package com.demo.gyw.service;

import com.demo.gyw.base.Demo;

public interface UserService {
     Demo addUser(Demo demo);

     Demo updateUser(Demo demo);

     void deleteUser(Long id);

}
