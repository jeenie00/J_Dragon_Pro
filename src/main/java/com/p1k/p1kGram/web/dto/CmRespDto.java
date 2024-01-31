package com.p1k.p1kGram.web.dto;

import lombok.AllArgsConstructor; // parameter가 있는 생성자를 자동으로 생성
import lombok.Data; // lombok 기능의 집합체 (getter,setter,RequiredArgsC, Tostring EqualsAndH 의 집합)
import lombok.NoArgsConstructor; // parameter가 없는 생성자를 자동으로 생성

@Data 
@AllArgsConstructor
@NoArgsConstructor

// 공통된 저장 값을 설정 해놓음 
// 값을 제네릭 타입으로 받음
public class CmRespDto<T> {
	private int statuscode;
	private T data;
}
