package br.com.fiap.fiaproupasdelivery.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.fiap.fiaproupasdelivery.entities.Entregador;

public class LoginDAO {
	
	public Session session;

	public void setSession(Session session){
		this.session = session;
	}

	public Entregador findBylogin(String user, String pass) {
		Entregador c = new Entregador();
		this.session.beginTransaction();
		String hql = "FROM entregador E WHERE E.username = :entregador and E.password = :password";
		Query query = session.createQuery(hql);
		query.setParameter("entregador", user);
		query.setParameter("entregador", pass);
		c = (Entregador) query.uniqueResult();
		
		return c;
	}
}
