package com.rays.service01.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.service01.feignclient.Service02FeignClient;

@RestController
@RequestMapping(value = "User")
public class UserCtl {

	@Autowired
	public Service02FeignClient service02FeignClient;

	@GetMapping("display")
	public String display() {
		return service02FeignClient.display();
	}

	@PostMapping("submit")
	public String submit() {
		return "service01 submit method..!!";
	}

}
