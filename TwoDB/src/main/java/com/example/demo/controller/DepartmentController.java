package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Department;
import com.example.demo.repo.DepartmentRepository;
import com.example.demo.repo1.TestRepository;

@RestController
@CrossOrigin(origins = "*")
public class DepartmentController {
	
	@Autowired
	DepartmentRepository deptRepo;
	
	@Autowired
	TestRepository testRepo;
	
	@GetMapping(path="/getComputerScienceDepartment")
	public Department getComputerScienceDepartment() {
		List<Department> deptList = deptRepo.findAllById(List.of(9901));
		System.out.println(testRepo.findById(1).get().getName());
		return deptList.get(0);
	}
	
	@GetMapping(path="/getTestData")
	public Department getTestData() {
		List<Department> deptList = deptRepo.findAllById(List.of(9901));
		return deptList.get(0);
	}

}
