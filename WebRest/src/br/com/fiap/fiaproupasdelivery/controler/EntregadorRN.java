package br.com.fiap.fiaproupasdelivery.controler;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fiaproupasdelivery.dao.GenericDAO;
import br.com.fiap.fiaproupasdelivery.dao.GenericEntregador;
import br.com.fiap.fiaproupasdelivery.entities.Entregador;
import br.com.fiap.fiaproupasdelivery.util.DaoFactory;

public class EntregadorRN {

	public GenericEntregador<Entregador, Long> entregadorDAO;
	
	public EntregadorRN(){
		entregadorDAO = DaoFactory.criarEntregadorDAO();
	}
	
	public boolean salvar(Entregador e){
		
		boolean retorno = this.entregadorDAO.create(e);
		
		return retorno;
	}
	
	public boolean alterar(Entregador e){
		
		boolean retorno = this.entregadorDAO.update(e);
		
		return retorno;
	}

	public boolean excluir(Entregador e){
		
		boolean retorno = this.entregadorDAO.delete(e);
		
		return retorno;
	}	
	
	public Entregador buscarEntregador(Long id){
		
		Entregador en = new Entregador();
		en = this.entregadorDAO.findById(id);
		
		return en;
	}
	
	public Entregador loginEntregador(String user, String pass){
		
		Entregador en = new Entregador();
		en = this.entregadorDAO.findBylogin(user, pass);
		
		return en;
	}
	
	public List<Entregador> buscarEntregadores(){
		
		List<Entregador> entregadores = new ArrayList<Entregador>();
		entregadores = this.entregadorDAO.findAll();
		
		return entregadores;
	}
}
