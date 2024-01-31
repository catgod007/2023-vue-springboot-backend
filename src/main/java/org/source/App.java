package org.source;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//启动类
@SpringBootApplication      //启动类的主注解
@MapperScan("org.source.mapper")  //持久层的位置
public class App{
    public static void main(String[] args) {

        SpringApplication.run(App.class,args);
    }

}