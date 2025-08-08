package com.senthil.ems_backend.service;

import java.util.List;

import com.senthil.ems_backend.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	EmployeeDto getEmployeeById(Long employeeId);
	List<EmployeeDto> getAllEmployees();
	EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee);
	void deleteEmployee(Long employeeId);
}
