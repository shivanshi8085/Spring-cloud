package com.rays.service01.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service02", url = "http://localhost:8082")
public interface Service02FeignClient {

	@GetMapping("/service02/User/display")
	String display();
}
