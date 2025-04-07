package com.example.cacibproject;

import com.example.cacibproject.service.MQMessageServiceListener;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@OpenAPIDefinition
public class CacibProjectApplication {




    public static void main(String[] args) {


       // SpringApplication.run(CacibProjectApplication.class, args);
        ApplicationContext applicationContext = SpringApplication.run(CacibProjectApplication.class, args);

     //   BeanFactory applicationContext ;
        MQMessageServiceListener service = applicationContext.getBean(MQMessageServiceListener.class);
        service.receive("");

    }


}