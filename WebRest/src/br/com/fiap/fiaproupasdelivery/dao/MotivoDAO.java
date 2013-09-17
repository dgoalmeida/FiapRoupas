package br.com.fiap.fiaproupasdelivery.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.com.fiap.fiaproupasdelivery.entities.Motivo;

public class MotivoDAO implements GenericDAO<Motivo, Long>{

	public Session session;

	public void setSession(Session session){
		this.session = session;
	}
	
	@Override
	public boolean create(Motivo t) {
		boolean retorno = false;
		try{
		this.session.beginTransaction();
		this.session.save(t);
		this.session.getTransaction().commit();
		this.session.close();
		retorno = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return retorno;
	}

	@Override
	public boolean update(Motivo t) {
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
	public boolean delete(Motivo t) {
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

	@Override
	public List<Motivo> findAll() {
		
		List<Motivo> motivos = new ArrayList<Motivo>();
		
		this.session.beginTransaction();
		motivos = this.session.createCriteria(Motivo.class).list();
		this.session.close();
		
		return motivos;
	}

	@Override
	public Motivo findById(Long id) {
		
		Motivo c = new Motivo();
		this.session.beginTransaction();
		c = (Motivo) this.session.get(Motivo.class, id);
		this.session.close();
		
		return c;
	}

}
