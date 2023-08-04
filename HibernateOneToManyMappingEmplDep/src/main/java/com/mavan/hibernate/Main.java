package com.mavan.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main 
{
	public static void main(String[] args) 
	{
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Department.class);
		config.addAnnotatedClass(Employee.class);
		
		SessionFactory sessionfactory = config.buildSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		// First object Department
		
		Department dp1 = new Department();
		dp1.setDepartmentname("HR Department");
		dp1.setDepartmentlocation("Bhopal");
		
		Department dp2 = new Department();
		dp2.setDepartmentname("CSE Department");
		dp2.setDepartmentlocation("Indore");
		
		//create one list
		List<Employee> emplist1 = new ArrayList<Employee>();
		List<Employee> emplist2 = new ArrayList<Employee>();

		// First object Employee..
		
		Employee emp1 = new Employee();
		emp1.setEmployeename("Ansar");
		emp1.setEmployeeage(22);
		emp1.setEmployeesalary(50000f);
		emp1.setEmployeeemail("anshuagh@gmail.com");
		emplist1.add(emp1); //add employee1 into the list 
		
		Employee emp2 = new Employee();
		emp2.setEmployeename("Indrakka");
		emp2.setEmployeeage(32);
		emp2.setEmployeesalary(55000f);
		emp2.setEmployeeemail("indrakka@gmail.com");
		emplist1.add(emp2); //add employee2 into the list 
		
		
		Employee emp3 = new Employee();
		emp3.setEmployeename("Mansi");
		emp3.setEmployeeage(22);
		emp3.setEmployeesalary(56000f);
		emp3.setEmployeeemail("mansi@gmail.com");
		emplist2.add(emp3); //add employee3 into the list 
		
		Employee emp4 = new Employee();
		emp4.setEmployeename("Lavanya");
		emp4.setEmployeeage(21);
		emp4.setEmployeesalary(65000f);
		emp4.setEmployeeemail("lavanya@gmail.com");
		emplist2.add(emp4); //add employee4 into the list 
		
		dp1.setEmployee(emplist1);
		session.save(dp1);
		dp2.setEmployee(emplist2);
		session.save(dp2);

		transaction.commit();
		
	}
}
