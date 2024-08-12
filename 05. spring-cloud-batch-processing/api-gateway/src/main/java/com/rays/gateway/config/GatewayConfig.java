package com.rays.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes().route("service01", r -> r.path("/service01/**").uri("lb://service01"))
				.route("service02", r -> r.path("/service02/**").uri("lb://service02"))
				.route("ORS10", r -> r.path("/ORS10/**").uri("lb://ORS10")).build();
	}
}
