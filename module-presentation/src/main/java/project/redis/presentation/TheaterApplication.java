package project.redis.presentation;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {
        "project.redis.application",
        "project.redis.presentation",
        "project.redis.infrastructure"
})
public class TheaterApplication {
    public static void main(String[] args) {
        SpringApplication.run(TheaterApplication.class, args);
    }
}
