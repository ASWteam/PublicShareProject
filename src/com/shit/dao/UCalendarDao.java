package com.shit.dao;

import java.util.List;

import com.shit.dto.UCalendar;

public interface UCalendarDao {
	public List<UCalendar> select();

	
	 public int add(UCalendar calendar);			// 일정 추가
	 public int modify(UCalendar calendar);			// 수정
	 public int remove(int id);						// 삭제
	 
	 public List<UCalendar> findAll();				// 기본 일정표 출력
	 public List<UCalendar> findById(int id);				
	 public List<UCalendar> findByTitle(String title);
//	 public List<Calendar> findByUser(int user_id);
	 
//	 특정 날짜 클릭스 이벤트 추가
//	 특정 범위 기간 클릭시 이벤트 추가

}
