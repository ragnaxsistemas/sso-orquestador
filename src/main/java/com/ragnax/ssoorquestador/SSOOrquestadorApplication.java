package com.ragnax.ssoorquestador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.ragnax.ssoorquestador.configuration.FactoryApiProperties;


@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@EnableConfigurationProperties(FactoryApiProperties.class)
public class SSOOrquestadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SSOOrquestadorApplication.class, args);
	}

}
