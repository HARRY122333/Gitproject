package com.csi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csi.dao.EmployeeDao;
import com.csi.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	 EmployeeDao employeeDao;
	
	@Override
	public void signUp(Employee employee) {
		employeeDao.signUp(employee);
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean signIn(String empEmailId, String empPassword) {
		return employeeDao.signIn(empEmailId, empPassword);
		
		// TODO Auto-generated method stub
	}

	@Override
	public void saveAllData(List<Employee> employees) {
		employeeDao.saveAllData(employees);
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> getAllData() {
		// TODO Auto-generated method stub
		return employeeDao.getAllData();
	}

	@Override
	public Employee getDataById(int empId) {
		// TODO Auto-generated method stub
		return employeeDao.getDataById(empId);
	}

	@Override
	public Employee getDataByName(String empName) {
		// TODO Auto-generated method stub
		return employeeDao.getDataByName(empName);
	}

	@Override
	public void updateData(int empId, Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.updateData(empId, employee);
	}

	@Override
	public void deleteData(int empID) {
		// TODO Auto-generated method stub
		employeeDao.deleteData(empID);
		
	}

	@Override
	public void deleteAllData() {
		// TODO Auto-generated method stub
		employeeDao.deleteAllData();
	}

}
