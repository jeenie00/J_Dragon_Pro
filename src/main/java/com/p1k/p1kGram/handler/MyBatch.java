package com.p1k.p1kGram.handler;

// import java
import java.util.List;

// spring
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

// lombok
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class MyBatch {

	private final ExceptionList exceptionList;
	
	@Scheduled(fixedDelay = 1000*60*10) // Cron 정기적 실행
	public void excute() {
		List<String> exList = exceptionList.getExList();
		// insert Database
		exList.clear();
	}
}