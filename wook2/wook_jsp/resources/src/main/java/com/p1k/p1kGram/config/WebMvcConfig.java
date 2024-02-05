package com.p1k.p1kGram.config;

// spring web 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

//web.xml 파일 정도로 생각하면됨 
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	
	// value (factory) - 간단하게 application 파일에 설정해놓은곳으로 접근을 가능하게함
	@Value("${file.path}") 
	private String uploadFolder;
	
	// ResourcegHandler 업로드 파일 설정
	// 즉 정적 리소스의 파일지원 정도로 생각하면됨
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		WebMvcConfigurer.super.addResourceHandlers(registry);
		// 기본 정적 위치+upload로 바꿔줌(static/resource/upload) → 해당위치에서 찾아줌 
		registry.addResourceHandler("/upload/**") 
		.addResourceLocations("file:///"+uploadFolder) // ↑ 저장하는 실질적 경로는 설정해줌
		.setCachePeriod(60*10*6) // 타임값을 표현 캐시에 해당 리소스 지속시간을 설정함
		.resourceChain(true)
		.addResolver(new PathResourceResolver());
	}
}