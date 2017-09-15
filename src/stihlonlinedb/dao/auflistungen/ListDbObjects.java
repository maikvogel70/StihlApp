package stihlonlinedb.dao.auflistungen;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import stihlonlinedb.entities.Bildablage;
import stihlonlinedb.entities.Einsatzzweck;
import stihlonlinedb.entities.Fuehrungsschienen;
import stihlonlinedb.entities.Ketten;
import stihlonlinedb.entities.Kunde;
import stihlonlinedb.entities.Produkte;
import stihlonlinedb.entities.Saege;
import stihlonlinedb.entities.Zubehoer;

public class ListDbObjects {

	private static final String FROM_CLAUSE_PRODUKTE = "FROM stihlonlinedb.entities.Produkte";
	private static final String FROM_CLAUSE_BILDER = "FROM stihlonlinedb.entities.Bildablage";
	private static final String FROM_CLAUSE_EINSATZ = "FROM stihlonlinedb.entities.Einsatzzweck";
	private static final String FROM_CLAUSE_KETTEN = "FROM stihlonlinedb.entities.Ketten";
	private static final String FROM_CLAUSE_FUEHRUNG = "FROM stihlonlinedb.entities.Fuehrungsschienen";
	private static final String FROM_CLAUSE_SAEGE = "FROM stihlonlinedb.entities.Saege";
	private static final String FROM_CLAUSE_ZUBEHOER = "FROM stihlonlinedb.entities.Zubehoer";
	private static final String FROM_CLAUSE_KUNDE = "FROM stihlonlinedb.entities.Kunde";

	private SessionFactory sessionFactory;

	public ListDbObjects(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Produkte> getAllProdukte() {
		return (List<Produkte>) getObjects(sessionFactory.openSession(), FROM_CLAUSE_PRODUKTE);
	}

	public List<Bildablage> getAllBilder() {
		return (List<Bildablage>) getObjects(sessionFactory.openSession(), FROM_CLAUSE_BILDER);
	}

	public List<Einsatzzweck> getAllEinsatzzwecke() {
		return (List<Einsatzzweck>) getObjects(sessionFactory.openSession(), FROM_CLAUSE_EINSATZ);
	}

	public List<Zubehoer> getAllZubehoer() {
		return (List<Zubehoer>) getObjects(sessionFactory.openSession(), FROM_CLAUSE_ZUBEHOER);
	}

	public List<Saege> getAllSaegen() {
		return (List<Saege>) getObjects(sessionFactory.openSession(), FROM_CLAUSE_SAEGE);
	}

	public List<Ketten> getAllKetten() {
		return (List<Ketten>) getObjects(sessionFactory.openSession(), FROM_CLAUSE_KETTEN);
	}

	public List<Fuehrungsschienen> getAllFuerungsschienen() {
		return (List<Fuehrungsschienen>) getObjects(sessionFactory.openSession(), FROM_CLAUSE_FUEHRUNG);
	}

	public List<Kunde> getAllKunden() {
		return (List<Kunde>) getObjects(sessionFactory.openSession(), FROM_CLAUSE_KUNDE);
	}

	private List<?> getObjects(Session session, String fromClause) {
		List<?> objects = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			objects = session.createQuery(fromClause).list();
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
