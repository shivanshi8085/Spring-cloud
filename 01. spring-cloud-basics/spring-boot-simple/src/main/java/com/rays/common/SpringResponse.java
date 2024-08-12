package com.rays.common;

import java.util.HashMap;
import java.util.Map;

public class SpringResponse {

	private String message;

	private String data;

	private Map<String, Object> result = new HashMap<String, Object>();

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

}
