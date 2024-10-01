package dev.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@GetMapping
    public String getEmployee() {
        return "Get employee";
    }
	
	@PostMapping
    public String addEmployee() {
        return "Add employee";
    }
	
	@PutMapping("/{employeeId}")
    public String updateEmployee(@PathVariable String employeeId) {
        return "Update employee " + employeeId;
    }
	
	@DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable String employeeId) {
        return "Delete employee " + employeeId;
    }
}
