package com.csi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csi.model.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

   private static SessionFactory factory= new AnnotationConfiguration().configure().buildSessionFactory();
   
	
	
	@Override
	public void signUp(Employee employee) {
		
		Session session =factory.openSession();
		Transaction transaction =session.beginTransaction();
		session.save(employee);
		transaction.commit();
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean signIn(String empEmailId, String empPassword)
	{
		boolean flag=false;
		Session session=factory.openSession();
		String teste;
		String testp;
		List<Employee>empList= session.createQuery("from Employee").list();
		for(Employee employee:empList )
		{	teste = employee.getEmpEmailId();
			testp = employee.getEmpPassword();
			//System.out.println(teste);
			//System.out.println(empEmailId);
			if (teste.equals(empEmailId) && testp.equals(empPassword))
			{
				//System.out.println(empList);
				flag=true;
				break;
			}
		}
		
		// TODO Auto-generated method stub
		return flag;
	}

	@Override
	public void saveAllData(List<Employee> employees) {
		// TODO Auto-generated method stub
		Session session =factory.openSession();
		
		for (Employee e: employees)
		{
			Transaction transaction =session.beginTransaction();
			session.save(e);
			transaction.commit();
		}
		
	}

	@Override
	public List<Employee> getAllData() {
		Session session=factory.openSession();
		List<Employee>empList= session.createQuery("from Employee").list();
		
		// TODO Auto-generated method stub
		return empList;
	}

	@Override
	public Employee getDataById(int empId) {
		Session session=factory.openSession();
		Employee employee= (Employee) session.get(Employee.class,empId);
				
		
		// TODO Auto-generated method stub
		return employee;
	}

	@Override
	public Employee getDataByName(String empName) {
		Session session=factory.openSession();
	List<Employee>employee=session.createQuery("from Employee").list();
	
	Employee ee=new Employee();
	for(Employee employee1:employee){
		if(employee.getEmpName()){
			
			ee.setEmpId(employee.getEmpName());
		}
		
	}
		
		// TODO Auto-generated method stub
		return employee;
	}

	@Override
	public void updateData(int empId, Employee employee) {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Employee e1= (Employee) session.get(Employee.class,empId);
		if(e1.getEmpId()==empId)
		{
	e1.setEmpName(employee.getEmpName());
	e1.setEmpAddress(employee.getEmpAddress());
	e1.setContactNumber(employee.getContactNumber());
	e1.setEmpDob(employee.getEmpDob());
	e1.setEmpEmailId(employee.getEmpEmailId());
	e1.setEmpPassword(employee.getEmpPassword());
	
		session.update(e1);
		transaction.commit();
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteData(int empID) {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Employee e1= (Employee) session.get(Employee.class,empID);
		if(e1.getEmpId()==empID)
		{
	
		session.delete(e1);
		transaction.commit();
		}
			// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllData() {
		Session session=factory.openSession();
	
		List<Employee>empList= session.createQuery("from Employee").list();
		
		for(Employee employee:empList)
		{
			Transaction transaction=session.beginTransaction();
			session.delete(employee);
			transaction.commit();
			
		}
			// TODO Auto-generated method stub
		
	}

}
