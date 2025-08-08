package com.senthil.ems_backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.senthil.ems_backend.dto.EmployeeDto;
import com.senthil.ems_backend.entity.Employee;
import com.senthil.ems_backend.exception.ResourceNotFoundException;
import com.senthil.ems_backend.mapper.EmployeeMapper;
import com.senthil.ems_backend.repository.EmployeeRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeMapper.maptoEmployee(employeeDto);
		Employee createEmployee = employeeRepository.save(employee);
		return EmployeeMapper.maptoEmployeeDto(createEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(()->new ResourceNotFoundException("Employee is not exist with given ID "+employeeId));
		return EmployeeMapper.maptoEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee)->EmployeeMapper.maptoEmployeeDto(employee)).collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee is not exist with the given ID "+employeeId));
		employee.setFirstName(updateEmployee.getFirstName());
		employee.setLastName(updateEmployee.getLastName());
		employee.setEmail(updateEmployee.getEmail());
		
		Employee updatedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.maptoEmployeeDto(updatedEmployee);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee is not exist with the given ID "+employeeId));
		employeeRepository.deleteById(employeeId);
	}
	
	
	
	
	
}




