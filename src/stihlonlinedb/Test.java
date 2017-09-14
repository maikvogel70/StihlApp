package stihlonlinedb;

import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import stihlonlinedb.entities.Saege;

public class Test {
	private SessionFactory sessionFactory;

	public static void main(String[] args) {
		Test test = new Test();
		try {
			test.setUp();
			test.listEmployees();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void setUp() throws Exception {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
				.build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble
			// building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy(registry);
			e.printStackTrace();
		}
	}

	public void listEmployees() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			java.util.List employees = session.createQuery("FROM stihlonlinedb.entities.Saege").list();
			for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
				Saege saege = (Saege) iterator.next();
				System.out.print("First Name: " + saege.getName());
				System.out.print("  Last Name: " + saege.getHubraum());
				System.out.println("  Salary: " + saege.getSchienenlaenge());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
