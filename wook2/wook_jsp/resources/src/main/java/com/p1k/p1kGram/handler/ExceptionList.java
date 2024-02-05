package com.p1k.p1kGram.handler;

// java
import java.util.ArrayList;
import java.util.List;

// spring
import org.springframework.stereotype.Component;

// lombok
import lombok.Data;

@Data
@Component
// 스프링의 다양한 예외처리 방식 추가하기
public class ExceptionList {
	
	public List<String> exList = new ArrayList<>();
	
	public void addExceptionList(String str) {
		exList.add(str);
	}
}