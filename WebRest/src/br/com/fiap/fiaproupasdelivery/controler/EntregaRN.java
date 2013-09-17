package br.com.fiap.fiaproupasdelivery.controler;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fiaproupasdelivery.dao.GenericDAO;
import br.com.fiap.fiaproupasdelivery.entities.Entrega;
import br.com.fiap.fiaproupasdelivery.util.DaoFactory;

public class EntregaRN {

	public GenericDAO<Entrega, Long> entregaDAO;
	
	public EntregaRN(){
		entregaDAO = DaoFactory.criarEntregaDAO();
	}
	
	public boolean salvar(Entrega e){
		boolean retorno = false;
		retorno = this.entregaDAO.create(e);
		return retorno;
	}
	
	public boolean alterar(Entrega e){
		boolean retorno = false;
		retorno = this.entregaDAO.update(e);
		return retorno;
	}
	
	public boolean excluir(Entrega e){
		boolean retorno = false;
		retorno = this.entregaDAO.delete(e);
		return retorno;
	}
	
	public Entrega buscarEntrega(Long id){
		
		Entrega en = new Entrega();
		en = this.entregaDAO.findById(id);
		return en;
	}
	
	public List<Entrega> buscarEntregas(){
		
		List<Entrega> entregas = new ArrayList<Entrega>();
		entregas = this.entregaDAO.findAll();
		return entregas;
	}
}
