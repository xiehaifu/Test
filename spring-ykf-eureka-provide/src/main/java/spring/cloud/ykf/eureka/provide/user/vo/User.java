package spring.cloud.ykf.eureka.provide.user.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String name;
    int age;

}
