package com.shit.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.shit.dto.UCalendar;

public class UCalendarDaoImplTest {
	UCalendarDaoImpl uc = new UCalendarDaoImpl();

	@Test
	public void testGetConnection() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelect() {
		List<UCalendar> u = uc.select();
		for (UCalendar calendar : u) {
			System.out.println(calendar);
		}
	}

	@Test
	public void testAdd() {
//		  Date today = new Date();
//		  SimpleDateFormat sdf0;
//		  sdf0 = new SimpleDateFormat("yyyyMMdd");
//		  System.out.println(sdf0.format(today));
		UCalendar u = new UCalendar();
//		u.setId(8);
		u.setTitle("wtf");
		u.setTooltip("stfu");
		u.setContext("lmao");
		u.setStartdate("170608");
		u.setEnddate("170608");
		uc.add(u);
		System.out.println(u);

	}

	@Test
	public void testModify() {
		List<UCalendar> u = uc.findById(21);
		UCalendar ucal = null;

		ucal = u.get(0);
		ucal.setTitle("baaa");
		uc.modify(ucal);
	}

	
	@Test
	public void testRemove() {
		uc.remove(2);
	}

	@Test
	public void testFindAll() {
		List<UCalendar> u = uc.findAll();
		for (UCalendar calendar : u) {
			System.out.println(calendar);
		}
	}

	@Test
	public void testFindById() {
		List<UCalendar> ucal = uc.findById(21);
		for (UCalendar calendar : ucal) {
			System.out.println(calendar);
		}
	}

	@Test
	public void testFindByTitle() {
		List<UCalendar> ucal = uc.findByTitle("gg");
		for (UCalendar calendar : ucal) {
			System.out.println(calendar);
		}
	}

}
