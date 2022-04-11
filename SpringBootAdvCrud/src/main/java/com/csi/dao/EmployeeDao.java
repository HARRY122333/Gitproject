package com.csi.dao;

import java.util.List;

import com.csi.model.Employee;

public interface EmployeeDao {

public void signUp(Employee employee);

public boolean signIn(String empEmailId,String empPassword);

public void saveAllData(List<Employee> employees);

public List<Employee> getAllData();

public Employee getDataById(int empId);

public Employee getDataByName(String empName);

public void updateData(int empId,Employee employee);

public void deleteData(int empID);

public void deleteAllData();


}
