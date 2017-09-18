package stihlonlinedb.dao.auflistungen;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import stihlonlinedb.entities.Saege;
import stihlonlinedb.entities.Zubehoer;

public class DbCommands implements IClauses {

	private SessionFactory sessionFactory;

	public DbCommands(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Saege> getSaegeById(int id) {
		String q = "FROM stihlonlinedb.entities.Saege as s WHERE ID = " + id;
		return (List<Saege>) getObject(q);
	}

	public List<Zubehoer> getZubehoerById(int id) {
		String q = "FROM stihlonlinedb.entities.Zubehoer as s WHERE ID = " + id;
		return (List<Zubehoer>) getObject(q);
	}

	private List<?> getObject(String query) {
		Session session = sessionFactory.openSession();
		List<?> objects = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			objects = session.createQuery(query).list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return objects;
	}
}
