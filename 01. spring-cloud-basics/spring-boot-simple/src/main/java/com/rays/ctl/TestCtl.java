package com.rays.ctl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.ORSResponse;
import com.rays.common.SpringResponse;
import com.rays.dto.UserDTO;

@RestController
@RequestMapping(value = "Test")
public class TestCtl {

	@GetMapping
	public SpringResponse display() {

		SpringResponse res = new SpringResponse();

		res.setMessage("data addedd successfully");

		UserDTO dto = new UserDTO();
		/*
		 * dto.setId(10L); dto.setFirstName("sagar"); dto.setLastName("yash");
		 * dto.setLoginId("pqr@gmail.com"); dto.setPassword("pqr123");
		 */

		Map map = new HashMap();
		map.put("dto", dto);

		res.setResult(map);

		return res;
	}

	@GetMapping("testORSResponse")
	public ORSResponse testORSResponse() {

		ORSResponse res = new ORSResponse();

		Map errors = new HashMap();
		errors.put("firstName", "first name is required");
		errors.put("lastName", "last name is required");
		errors.put("loginId", "login id is required");
		errors.put("password", "password is required");

		res.addInputError(errors);

		UserDTO dto = new UserDTO();
		/*
		 * dto.setId(100); dto.setFirstName("sagar"); dto.setLastName("yash");
		 * dto.setLoginId("pqr@gmail.com"); dto.setPassword("pqr123");
		 */

		res.addData(dto);

		res.addMessage("login & password invalid");

		res.addResult("hello", "hi");

		return res;
	}

}
