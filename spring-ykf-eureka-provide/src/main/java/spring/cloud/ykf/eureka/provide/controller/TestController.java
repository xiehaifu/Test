package spring.cloud.ykf.eureka.provide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.ykf.eureka.provide.user.service.Testservice;

@RestController
public class TestController {
    @Value("${server.port}")
    String port;
    @Autowired
    Testservice testservice;
    @GetMapping(value = "/hi")
    public String aa(@RequestParam(value = "name", defaultValue = "forezp") String name) {

        String s = testservice.getS(1);
        return "hi " + name + " ,i am from port:" + port+"name:"+s;
    }

}
