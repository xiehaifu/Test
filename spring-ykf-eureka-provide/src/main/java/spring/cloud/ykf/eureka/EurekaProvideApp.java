package spring.cloud.ykf.eureka;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//标明是服务提供者
@EnableEurekaClient
// springboot项目
@SpringBootApplication
@MapperScan("spring.cloud.ykf.eureka.provide.user.dao")
public class EurekaProvideApp {
    public static void main(String[] args) {
        System.err.println("EurekaProvideApp  Service Strat Success!");
        SpringApplication.run(EurekaProvideApp.class, args);
    }


}
