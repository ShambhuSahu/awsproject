package com.example.employeeproject.employee;

import com.example.employeeproject.model.EmployeeRequest;
import com.example.employeeproject.model.EmployeeResponse;
import com.example.employeeproject.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest employeeRequest)
    {
        EmployeeResponse employeeResponse=employeeService.createEmployee(employeeRequest);
        return new ResponseEntity<>(employeeResponse, HttpStatus.CREATED);
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<EmployeeRequest> getByEmployeeId(@PathVariable Long employeeId)
    {
        EmployeeRequest employeeRequest=employeeService.getAllEmployee(employeeId);
        return new ResponseEntity<>(employeeRequest,HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeRequest>> getAllEmployees()
    {
        List<EmployeeRequest> employeeRequestList=employeeService.getAllEmployees();

        return new ResponseEntity<>(employeeRequestList,HttpStatus.OK);
    }

    @PutMapping("/employees/{employeeId}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable Long employeeId,@RequestBody EmployeeRequest employeeRequest)
    {
        EmployeeResponse employeeResponse=employeeService.updateEmployee(employeeId,employeeRequest);
        return new ResponseEntity<>(employeeResponse,HttpStatus.OK);
    }

}
