package com.ganesh.repo;


import org.springframework.data.jpa.repository.JpaRepository;


import com.ganesh.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
