package com.rays.service01.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.service01.feignclient.Service02FeignClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping(value = "User")
public class UserCtl {

	@Autowired
	public Service02FeignClient service02FeignClient;

	@GetMapping("display")
	@CircuitBreaker(name = "service02Breaker", fallbackMethod = "service02Fallback")
	public String display() {
		return service02FeignClient.display();
	}

	@PostMapping("submit")
	public String submit() {
		return "service01 submit method..!!";
	}

	public String service02Fallback(Throwable throwable) {
		System.out.println("Fallback is executed because service is down : " + throwable.getMessage());
		return "Fallback response: Service is down";
	}

}
