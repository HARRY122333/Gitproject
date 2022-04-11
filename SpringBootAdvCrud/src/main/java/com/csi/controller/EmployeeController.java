package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
    EmployeeService employeeService;

    @PostMapping("/signUp")
    public String signUp(@RequestBody Employee employee)
    {
        employeeService.signUp(employee);

        return "Employee Signup Successfully";
    }

    @PostMapping("/signIn")
    public boolean signIn(@RequestBody Employee emp )
    {
        return employeeService.signIn(emp.getEmpEmailId(),emp.getEmpPassword());
    }

    @GetMapping("/getAllData")
    public List<Employee> getAllData()
    {	
    	 System.out.println("Hello World");
        return employeeService.getAllData();
    }

    @GetMapping("/getDataById/{empId}")
    public Employee getDataById(@PathVariable int empId)
    {
        return employeeService.getDataById(empId);
    }

    @GetMapping("/getDataByName/{empName}")
    public Employee getDataByName(@PathVariable String empName)
    {
        return employeeService.getDataByName(empName);
    }

    @PostMapping("/saveAllData")
    public String saveAllData(@RequestBody List<Employee> employees)
    {
        employeeService.saveAllData(employees);
        return "Sall All Data Done";
    }

    @PutMapping("/updateData/{empId}")
    public String updateData(@PathVariable int empId, @RequestBody Employee employee)
    {
        employeeService.updateData(empId, employee);
        return "Data updated Successfully";
    }

    @DeleteMapping("/deleteData/{empId}")
    public String deleteData(@PathVariable int empId)
    {
        employeeService.deleteData(empId);
        return "Data deleted Successfully";
    }

    @DeleteMapping("/deleteAllData")
    public String deleteAllData()
    {
        employeeService.deleteAllData();
        return "All Data Deleted Successfully";
    }


}
