package com.demo.gyw.java.test_class;

import com.demo.gyw.spring.transactional.bean.BeanLifeCycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author GouYaoWen
 * @Description 测试控制器
 * @Date Create in 10:47 2019/12/3
 */
@RestController
public class TestController {

    @Autowired
    private BeanLifeCycle beanLifeCycle;

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        return "hi " + name + ",i am from port:" + port;
    }

    @RequestMapping("/")
    public String welcome() {
        return "欢迎您,Port:" + port +"----bean："+beanLifeCycle.objectAttribute;
    }
}
