package br.com.fiap.fiaproupasdelivery.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.com.fiap.fiaproupasdelivery.entities.Produto;

public class ProdutoDAO implements GenericDAO<Produto, Long>{

	public Session session;

	public void setSession(Session session){
		this.session = session;
	}
	
	@Override
	public boolean create(Produto t) {
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
	public boolean update(Produto t) {
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
	public boolean delete(Produto t) {
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
	public List<Produto> findAll() {

		List<Produto> produtos = new ArrayList<Produto>();
		
		this.session.beginTransaction();
		produtos = this.session.createCriteria(Produto.class).list();
		
		return produtos;
	}

	@Override
	public Produto findById(Long id) {
		Produto c = new Produto();
		this.session.beginTransaction();
		c = (Produto) this.session.get(Produto.class, id);
		this.session.close();
		
		return c;
	}

}
