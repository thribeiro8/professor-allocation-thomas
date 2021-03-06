package com.project.professor.allocation.thomas.repository.test;

import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.thomas.entity.Course;
import com.project.professor.allocation.thomas.repository.CourseRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class CourseRepositoryTest {

	SimpleDateFormat sdf = new SimpleDateFormat("HH:mmZ");

	@Autowired
	CourseRepository courseRepository;

	@Test
	public void findAll() {
		// Act
		List<Course> courses = courseRepository.findAll();

		// Print
		courses.forEach(System.out::println);
	}

	@Test
	public void findById() {
		// Act
		Course course = courseRepository.findById(1L).orElse(null);

		// Print
		System.out.println(course);
	}

	@Test
	public void findByNameContainingIgnoreCase() {
		// Act
		List<Course> courses = courseRepository.findByNameContainingIgnoreCase("Backend");

		// Print
		courses.forEach(System.out::println);
	}

	@Test
	public void save_create() {
		// Arrange
		Course course = new Course();
		course.setId(null);
		course.setName("Backend");

		// Act
		course = courseRepository.save(course);

		// Print
		System.out.println(course);
	}

	@Test
	public void save_update() {
		// Arrange
		Course course = new Course();
		course.setId(1L);
		course.setName("Frontend");

		// Act
		course = courseRepository.save(course);

		// Print
		System.out.println(course);
	}

	@Test
	public void deleteById() {
		// Act
		courseRepository.deleteById(1L);
	}

	@Test
	public void deleteAll() {
		// Act
		courseRepository.deleteAll();
	}

}
