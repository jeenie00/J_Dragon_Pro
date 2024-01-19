package com.p1k.p1kGram.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.p1k.p1kGram.web.dto.CMRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@ControllerAdvice
public class MyExceptionHandler {

	private final ExceptionList exceptionList;
	
	@ExceptionHandler(value = Exception.class)
	public CMRespDto<?> hello(Exception e) {
		exceptionList.addExceptionList(e.getMessage());
		return new CMRespDto<>(-1, "오류남");
	}
	
	
}