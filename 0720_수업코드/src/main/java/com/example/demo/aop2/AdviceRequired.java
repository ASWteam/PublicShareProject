package com.example.demo.aop2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
//이 어노테이션을 타입레벨과 메소드레벨에서 적용할 수 있도록
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface AdviceRequired { //interface를 어노테이션으로 선언
	
}
