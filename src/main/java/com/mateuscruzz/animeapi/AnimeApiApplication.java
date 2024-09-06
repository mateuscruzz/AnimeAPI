package com.mateuscruzz.animeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AnimeApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimeApiApplication.class, args);
    }

}
