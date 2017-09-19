package stihlonlinedb.db;

import java.io.Serializable;

import org.hibernate.SessionFactory;

import stihlonlinedb.dao.queries.IClauses;

public class DbCommands implements IClauses, Serializable {

	private SessionFactory sessionFactory;

}
