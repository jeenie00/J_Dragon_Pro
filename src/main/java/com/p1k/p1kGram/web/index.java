package com.p1k.p1kGram.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class index {
	@GetMapping(value = "/")
	public String pk1_index() {
		return "index";
	}
}