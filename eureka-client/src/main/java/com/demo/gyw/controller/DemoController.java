package com.demo.gyw.controller;

import com.demo.gyw.base.Demo;
import com.demo.gyw.mq.MQSender;
import com.demo.gyw.service.UserService;
import com.demo.gyw.service.LocalCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

/**
 * @Description: 事例Controller
 * @Author: gyw
 * @CreateDate: 2019/5/27 13:57
 * @Version: 1.0
 */
@RestController
public class DemoController {

    @Autowired
    private LocalCacheService service;

    @Autowired
    private UserService userService;

    @Autowired
    private MQSender mqSender;

    @GetMapping("getDemoById")
    public ResponseEntity<Demo> getDemo(@RequestParam String id) {
        try {
            return ResponseEntity.ok(service.getDemo(id));
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/mq")
    public ResponseEntity<Boolean> mq() {
        mqSender.send("Wings you're the hero,路飞是成为海贼王的男人！");
        return ResponseEntity.ok(true);
    }

    @PostMapping("save")
    public ResponseEntity<Demo> addDemo(Demo demo) {
        return ResponseEntity.ok(userService.addUser(demo));
    }
}
