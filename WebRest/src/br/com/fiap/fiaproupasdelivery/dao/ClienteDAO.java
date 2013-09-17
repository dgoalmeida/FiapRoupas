package br.com.fiap.fiaproupasdelivery.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.com.fiap.fiaproupasdelivery.entities.Cliente;
import br.com.fiap.fiaproupasdelivery.entities.Entregador;

public class ClienteDAO implements GenericDAO<Cliente, Long>{

	public Session session;
	
	public void setSession(Session session){
		this.session = session;
	}
	
	@Override
	public boolean create(Cliente t) {
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
	public boolean update(Cliente t) {
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
	public boolean delete(Cliente t) {
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
	public List<Cliente> findAll() {
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		this.session.beginTransaction();
		clientes = this.session.createCriteria(Cliente.class).list();
		//this.session.close();
		
		return clientes;
	}

	@Override
	public Cliente findById(Long id) {
		
		Cliente c = new Cliente();
		this.session.beginTransaction();
		c = (Cliente) this.session.get(Cliente.class, id);
		//this.session.close();
		
		return c;
	}

}
