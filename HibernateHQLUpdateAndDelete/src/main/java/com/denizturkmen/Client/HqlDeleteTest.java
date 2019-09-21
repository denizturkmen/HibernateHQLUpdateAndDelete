package com.denizturkmen.Client;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.denizturkmen.Util.HibernateUtil;

public class HqlDeleteTest {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		deleteByEmployeeId(sessionFactory);

	}

	private static void deleteByEmployeeId(SessionFactory sessionFactory) {

		int employeId = 1;

		try (Session session = sessionFactory.openSession()) {

			String DeleteHql = "DELETE FROM Employee Where employeeId=:employeId";
			Query query = session.createQuery(DeleteHql);
			query.setParameter("employeId", employeId);
			session.beginTransaction();
			int execute = query.executeUpdate();

			if (execute > 0) {
				System.out.println("Employee is deleted....");
				session.getTransaction().commit();
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}
}