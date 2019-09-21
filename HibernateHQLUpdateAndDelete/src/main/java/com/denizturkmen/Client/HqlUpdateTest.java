package com.denizturkmen.Client;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.denizturkmen.Util.HibernateUtil;

public class HqlUpdateTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		updateEmployeeById(sessionFactory);
	}

	private static void updateEmployeeById(SessionFactory sessionFactory) {
		int id=2;
		String newAdi="DENİZ";
		try (Session session = sessionFactory.openSession()) {
		
			String UpdateHQL = "UPDATE Employee Set employeeName=:newAdis WHERE employeeId=:id";
			
			Query query = session.createQuery(UpdateHQL);
			query.setParameter("id", id);
			query.setParameter("newAdis", newAdi);
			// 1 alan hql giden parametre ismi
			// 2 alan ise değişecek yer
			session.beginTransaction();
			int executeUpdate = query.executeUpdate();
			if(executeUpdate>0) {
				System.out.println("Employee is Updated");
				session.getTransaction().commit();
			}
			
		} catch (HibernateException e) {
			
		}
		
	}
}
;