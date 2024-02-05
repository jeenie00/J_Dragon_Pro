package com.p1k.p1kGram.handler;

// spring web
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

// import p1kGram (CmrespDto) 
import com.p1k.p1kGram.web.dto.CmRespDto;

// lombok
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@ControllerAdvice
public class MyExceptionHandler {

	private final ExceptionList exceptionList;
	
	// 예외처리를 하는 방식 
	@ExceptionHandler(value = Exception.class)
	public CmRespDto<?> hello(Exception e) {
		exceptionList.addExceptionList(e.getMessage());
		return new CmRespDto<>(-1, "오류오류오류! 예외가 발생함!");
	}	
}