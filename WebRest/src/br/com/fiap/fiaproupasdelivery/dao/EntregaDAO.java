package br.com.fiap.fiaproupasdelivery.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.com.fiap.fiaproupasdelivery.entities.Entrega;

public class EntregaDAO implements GenericDAO<Entrega, Long>{

public Session session;
	
	public void setSession(Session session){
		this.session = session;
	}
	
	@Override
	public boolean create(Entrega t) {
		boolean retorno = false;
		try{
		this.session.beginTransaction();
		this.session.save(t);
		this.session.getTransaction().commit();
		//this.session.close();
		retorno = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return retorno;
	}

	@Override
	public boolean update(Entrega t) {
		boolean retorno = false;
		try{
		this.session.beginTransaction();
		this.session.update(t);
		this.session.getTransaction().commit();
		//this.session.close();
		retorno = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return retorno;
	}

	@Override
	public boolean delete(Entrega t) {
		boolean retorno = false;
		try{
		this.session.beginTransaction();
		this.session.delete(t);
		this.session.getTransaction().commit();
		//this.session.close();
		retorno = true;
		}catch(Exception e){
			
		}
		return retorno;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Entrega> findAll() {

		List<Entrega> entregas = new ArrayList<Entrega>();
		
		this.session.beginTransaction();
		entregas = this.session.createCriteria(Entrega.class).list();
		
		return entregas;
	}

	@Override
	public Entrega findById(Long id) {

		Entrega c = new Entrega();
		this.session.beginTransaction();
		c = (Entrega) this.session.get(Entrega.class, id);
		this.session.close();
		
		return c;
	}

}
