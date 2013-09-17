package br.com.fiap.fiaproupasdelivery.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory  = buildSessionfFactory();
	
	public static SessionFactory buildSessionfFactory(){
		try{
			Configuration cfg = new Configuration();
			cfg.configure("Hibernate.cfg.xml");
			return cfg.buildSessionFactory();
		}catch(Throwable e){
			System.out.println("Criação inicial do Projeto Falhou");
			throw new ExceptionInInitializerError(e);
		}		
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
