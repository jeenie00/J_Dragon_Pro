package com.p1k.p1kGram.handler;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ExceptionList {
	
	public List<String> exList = new ArrayList<>();
	
	public void addExceptionList(String str) {
		exList.add(str);
	}
}