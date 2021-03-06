package com.project.professor.allocation.thomas.service.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.thomas.entity.Allocation;
import com.project.professor.allocation.thomas.service.AllocationService;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class AllocationServiceTest {

	SimpleDateFormat sdf = new SimpleDateFormat("HH:mmZ");

	@Autowired
	AllocationService allocationService;

	@Test
	public void findAll() {
		// Act
		List<Allocation> allocations = allocationService.findAll();

		// Print
		allocations.forEach(System.out::println);
	}

	@Test
	public void findById() {
		// Act
		Allocation allocations = allocationService.findById(6L);

		// Print
		System.out.println(allocations);
	}

	@Test
	public void findByProfessor() {
		// Act
		List<Allocation> allocations = allocationService.findByProfessor(1L);

		// Print
		allocations.forEach(System.out::println);
	}

	@Test
	public void findByCourse() {
		// Act
		List<Allocation> allocations = allocationService.findByCourse(1L);

		// Print
		allocations.forEach(System.out::println);
	}

	@Test
	public void save() throws ParseException {
		// Arrange
		Allocation allocation = new Allocation();
		allocation.setId(null);
		allocation.setDay(DayOfWeek.SUNDAY);
		allocation.setStartHour(sdf.parse("16:00-0300"));
		allocation.setEndHour(sdf.parse("20:00-0300"));
		allocation.setProfessorId(1L);
		allocation.setCourseId(1L);

		// Act
		allocation = allocationService.save(allocation);

		// Print
		System.out.println(allocation);
	}

	@Test
	public void update() throws ParseException {
		// Arrange
		Allocation allocation = new Allocation();
		allocation.setId(7L);
		allocation.setDay(DayOfWeek.MONDAY);
		allocation.setStartHour(sdf.parse("18:00-0300"));
		allocation.setEndHour(sdf.parse("21:00-0300"));
		allocation.setProfessorId(1L);
		allocation.setCourseId(1L);

		// Act
		allocation = allocationService.update(allocation);

		// Print
		System.out.println(allocation);
	}

	@Test
	public void deleteById() {
		// Act
		allocationService.deleteById(1L);
	}

	@Test
	public void deleteAll() {
		// Act
		allocationService.deleteAll();
	}

}
