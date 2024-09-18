package dev.waiyanhtet.springcloudconfigclient;

import dev.waiyanhtet.springcloudconfigclient.config.GreetPropertiesConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.OptionalInt;

@RestController
@SpringBootApplication
@RequiredArgsConstructor
public class SpringCloudConfigClientApplication {

    private final GreetPropertiesConfig greetPropertiesConfig;

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigClientApplication.class, args);
    }


    @GetMapping("/greet")
    public String greet() {
        var greet = greetPropertiesConfig.getGreet();
        return Optional.of(greet).orElse("Hello from client application");
    }

}
