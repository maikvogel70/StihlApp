package stihlonlinedb;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import stihlonlinedb.dao.auflistungen.ListDbObjects;
import stihlonlinedb.entities.Bildablage;
import stihlonlinedb.entities.Einsatzzweck;
import stihlonlinedb.entities.Fuehrungsschienen;
import stihlonlinedb.entities.Ketten;
import stihlonlinedb.entities.Kunde;
import stihlonlinedb.entities.Produkte;
import stihlonlinedb.entities.Saege;
import stihlonlinedb.entities.Zubehoer;

public class Test {
	private SessionFactory sessionFactory;

	public static void main(String[] args) {
		Test test = new Test();
		try {
			test.setUp();
			test.listProdukte();
			test.listBilder();
			test.listEinsatz();
			test.listFuehungsschienen();
			test.listKetten();
			test.listKunden();
			test.listSaegen();
			test.listZubehoer();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (test.sessionFactory != null) {
				test.sessionFactory.close();
			}
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

	public void listProdukte() {
		ListDbObjects objects = new ListDbObjects(sessionFactory);
		List<Produkte> allProdukte = objects.getAllProdukte();
		System.out.println("----- PRODUKTE -----------");
		for (Iterator<Produkte> iterator = allProdukte.iterator(); iterator.hasNext();) {
			Produkte produkte = iterator.next();
			System.out.print("Name: " + produkte.getName());
			System.out.println(" Bild: " + produkte);
		}

	}

	public void listBilder() {
		ListDbObjects objects = new ListDbObjects(sessionFactory);
		List<Bildablage> allBilder = objects.getAllBilder();
		System.out.println("----- BILDER -----------");
		for (Iterator<Bildablage> iterator = allBilder.iterator(); iterator.hasNext();) {
			Bildablage bild = iterator.next();
			System.out.println("Pfad: " + bild);
		}

	}

	public void listEinsatz() {
		ListDbObjects objects = new ListDbObjects(sessionFactory);
		List<Einsatzzweck> allProdukte = objects.getAllEinsatzzwecke();
		System.out.println("----- EINSATZZWECK -----------");
		for (Iterator<Einsatzzweck> iterator = allProdukte.iterator(); iterator.hasNext();) {
			Einsatzzweck einsatzzweck = iterator.next();
			System.out.println("Name: " + einsatzzweck);
		}
	}

	public void listZubehoer() {
		ListDbObjects objects = new ListDbObjects(sessionFactory);
		List<Zubehoer> allProdukte = objects.getAllZubehoer();
		System.out.println("----- Zubehoer -----------");
		for (Iterator<Zubehoer> iterator = allProdukte.iterator(); iterator.hasNext();) {
			Zubehoer zubehoer = iterator.next();
			System.out.println("Name: " + zubehoer);
		}
	}

	public void listSaegen() {
		ListDbObjects objects = new ListDbObjects(sessionFactory);
		List<Saege> allSaegen = objects.getAllSaegen();
		System.out.println("----- Zubehoer -----------");
		for (Iterator<Saege> iterator = allSaegen.iterator(); iterator.hasNext();) {
			Saege saege = iterator.next();
			System.out.println("Name: " + saege);
		}
	}

	public void listKetten() {
		ListDbObjects objects = new ListDbObjects(sessionFactory);
		List<Ketten> allKetten = objects.getAllKetten();
		System.out.println("----- KETTEN -----------");
		for (Iterator<Ketten> iterator = allKetten.iterator(); iterator.hasNext();) {
			Ketten kette = iterator.next();
			System.out.println("Name: " + kette);
		}
	}

	public void listFuehungsschienen() {
		ListDbObjects objects = new ListDbObjects(sessionFactory);
		List<Fuehrungsschienen> allFueSchies = objects.getAllFuerungsschienen();
		System.out.println("----- FÜHRUNGSSCHIENEN -----------");
		for (Iterator<Fuehrungsschienen> iterator = allFueSchies.iterator(); iterator.hasNext();) {
			Fuehrungsschienen fueSchi = iterator.next();
			System.out.println("Name: " + fueSchi);
		}
	}

	public void listKunden() {
		ListDbObjects objects = new ListDbObjects(sessionFactory);
		List<Kunde> allKunden = objects.getAllKunden();
		System.out.println("----- KUNDEN -----------");
		for (Iterator<Kunde> iterator = allKunden.iterator(); iterator.hasNext();) {
			Kunde kunde = iterator.next();
			System.out.println("Name: " + kunde);
		}
	}

}
