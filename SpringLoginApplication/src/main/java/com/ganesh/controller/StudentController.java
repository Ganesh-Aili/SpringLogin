package com.ganesh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.entity.Student;

import com.ganesh.repo.StudentRepo;



@RestController
@RequestMapping("/")
public class StudentController<StudentService> {
	
	@Autowired
	private StudentRepo studentRepo;
	

	@GetMapping("/getstudent")
	public List<Student> getAllStudents(){	
		return studentRepo.findAll();
	}
	
	@PostMapping("/student")
	public Student createStudent(@RequestBody Student student) {
		return studentRepo.save(student);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
		Student student = studentRepo.findById(id).orElseThrow();
		return ResponseEntity.ok(student);
	}
	
	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student studentDetails){
		Student student = studentRepo.findById(id)
				.orElseThrow();
		
		student.setSrollno(studentDetails.getSrollno());
		student.setSname(studentDetails.getSname());
		student.setSemail(studentDetails.getSemail());
		student.setSmarks(studentDetails.getSmarks());
		
		Student updateStudent = studentRepo.save(student);
		return ResponseEntity.ok(updateStudent);
	}
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Integer id){
		Student employee = studentRepo.findById(id).orElseThrow();
		
		studentRepo.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
