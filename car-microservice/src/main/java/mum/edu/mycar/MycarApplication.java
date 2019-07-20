package mum.edu.mycar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MycarApplication {
    public static void main(String[] args) {
        SpringApplication.run(MycarApplication.class, args);
    }

}
