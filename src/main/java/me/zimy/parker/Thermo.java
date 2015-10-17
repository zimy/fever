package me.zimy.parker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Dmitriy I. Yakovlev $lt;zimy&at;yandex$dot;ru&gt; on 26.09.15.
 * Entry point
 */
@EntityScan
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Thermo {
    public static void main(String[] args) {
        SpringApplication.run(Thermo.class, args);
    }
}
