package dev.waiyanhtet.springcloudconfigclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.OptionalInt;

@RefreshScope
@RestController
@SpringBootApplication
public class SpringCloudConfigClientApplication {

    @Value("${app.greet}")
    private String greet;

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigClientApplication.class, args);
    }


    @GetMapping("/greet")
    public String greet() {
        return Optional.of(greet).orElse("Hello from client application");
    }

}
