package ru.otus.springlibrary;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SpringLibraryAuth {

    public static void main(String[] args) {
        SpringApplication.run(SpringLibraryAuth.class);
    }

}
