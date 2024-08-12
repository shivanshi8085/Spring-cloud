package com.rays.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {

		SpringApplication.run(ApiGatewayApplication.class, args);

	}
}

/*
 * @Bean public CorsWebFilter corsWebFilter() { CorsConfiguration corsConfig =
 * new CorsConfiguration(); corsConfig.setAllowCredentials(true);
 * 
 * // Explicitly list allowed origins
 * corsConfig.addAllowedOrigin("http://localhost:4200");
 * 
 * // Specify allowed headers and methods corsConfig.addAllowedHeader("*");
 * corsConfig.addAllowedMethod("*");
 * 
 * UrlBasedCorsConfigurationSource source = new
 * UrlBasedCorsConfigurationSource(); source.registerCorsConfiguration("/**",
 * corsConfig);
 * 
 * return new CorsWebFilter(source); } }
 */
