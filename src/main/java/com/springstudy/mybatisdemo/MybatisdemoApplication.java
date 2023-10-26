package com.springstudy.mybatisdemo;

import com.springstudy.mybatisdemo.module.User;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MappedTypes(User.class)
@MapperScan("com.springstudy.mybatisdemo.mapper")
@SpringBootApplication
public class MybatisdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisdemoApplication.class, args);
	}

}
