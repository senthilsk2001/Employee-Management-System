package com.senthil.ems_backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senthil.ems_backend.dto.EmployeeDto;
import com.senthil.ems_backend.service.EmployeeService;

import lombok.AllArgsConstructor;
@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("api/employees")
public class EmployeeController {
	private EmployeeService employeeService;
	
	//Build Add Employee REST API
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	//Build get employee get API
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
		EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<>(employeeDto, HttpStatus.OK);
	}
	
	@GetMapping
	//Build getAllEmployees API
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> employees = employeeService.getAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	//Build updateEmployee API
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto updatedEmployee){
		EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
		return new ResponseEntity<>(employeeDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	//Build deleteEmployee API
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
		employeeService.deleteEmployee(employeeId);
		return ResponseEntity.ok("Employee Deleted Successfully");
	}
}




