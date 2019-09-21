package com.denizturkmen.Client;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Session;

import com.denizturkmen.Entity.Employee;
import com.denizturkmen.Util.HibernateUtil;

public class SaveEmployee {

	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			session.beginTransaction();
			
			Employee employee = new Employee();
			employee.setEmployeeName("Deniz TÜRKMEN");
			employee.setBonus(new BigDecimal(456545));
			employee.setDesignation("Arge");
			employee.setDoj(new Date());
			employee.setEmail("turkmen@gmail.com");
			employee.setSalary(455645D);
			
			Employee employee1 = new Employee();
			employee1.setEmployeeName("Eren TÜRKMEN");
			employee1.setBonus(new BigDecimal(422));
			employee1.setDesignation("IT");
			employee1.setDoj(new Date());
			employee1.setEmail("eren@gmail.com");
			employee1.setSalary(752D);
					
			Employee employee2 = new Employee();
			employee2.setEmployeeName("Besra TÜRKMEN");
			employee2.setBonus(new BigDecimal(978987));
			employee2.setDesignation("IKTISAT");
			employee2.setDoj(new Date());
			employee2.setEmail("besra@gmail.com");
			employee2.setSalary(64564D);

			session.save(employee);
			session.save(employee1);
			session.save(employee2);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
