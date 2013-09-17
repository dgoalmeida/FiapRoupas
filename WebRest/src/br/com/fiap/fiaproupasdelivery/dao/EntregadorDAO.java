package br.com.fiap.fiaproupasdelivery.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.fiap.fiaproupasdelivery.entities.Entregador;

public class EntregadorDAO implements GenericEntregador<Entregador, Long>{
	
public Session session;

public void setSession(Session session){
	this.session = session;
}
	
	@Override
	public boolean create(Entregador t) {
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
	public boolean update(Entregador t) {
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
	public boolean delete(Entregador t) {
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
	public List<Entregador> findAll() {

		List<Entregador> entregadores = new ArrayList<Entregador>();
		
		this.session.beginTransaction();
		entregadores = this.session.createCriteria(Entregador.class).list();
		this.session.close();
		
		return entregadores;
	}

	@Override
	public Entregador findById(Long id) {
		Entregador c = new Entregador();
		this.session.beginTransaction();
		c = (Entregador) this.session.get(Entregador.class, id);
		this.session.close();
		
		return c;
	}

	@Override
	public Entregador findBylogin(String user, String pass) {
		Entregador c = new Entregador();
		this.session.beginTransaction();
		String hql = "from Entregador s where s.username = '" + user + "' and s.password = '" + pass + "'";
		Query query = session.createQuery(hql);
		
		c = (Entregador) query.uniqueResult();
		
		return c;
	}
	

}
