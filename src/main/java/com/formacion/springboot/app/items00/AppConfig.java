package com.formacion.springboot.app.items00;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean("clienteRest")
    public RestTemplate registrarTemplate(){
       return new RestTemplate();
    }
}
