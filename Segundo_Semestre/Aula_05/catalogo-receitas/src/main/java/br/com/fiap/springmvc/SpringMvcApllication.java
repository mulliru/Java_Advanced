package br.com.fiap.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("br.com.fiap.springmvc.repository")
public class SpringMvcApllication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcApllication.class, args);
    }
}
