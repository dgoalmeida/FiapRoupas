package br.com.fiap.fiaproupasdelivery.controler;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fiaproupasdelivery.dao.GenericDAO;
import br.com.fiap.fiaproupasdelivery.entities.Motivo;
import br.com.fiap.fiaproupasdelivery.util.DaoFactory;

public class MotivoRN {

	public GenericDAO<Motivo, Long> motivoDAO;
	
	public MotivoRN(){
		motivoDAO = DaoFactory.criarMotivoDAO();
	}
	
	public boolean salvar(Motivo m){
		boolean retorno = false;
		retorno = this.motivoDAO.create(m);
		return retorno;
	}
	
	public boolean alterar(Motivo m){
		boolean retorno = false;
		retorno = this.motivoDAO.update(m);
		return retorno;
	}
	
	public boolean excluir(Motivo m){
		boolean retorno = false;
		retorno = this.motivoDAO.delete(m);
		return retorno;
	}
	
	public Motivo buscarMotivo(Long id){
		
		Motivo m = new Motivo();
		m = this.motivoDAO.findById(id);
		
		return m;
	}
	
	public List<Motivo> buscarMotivos(){
		
		List<Motivo> motivos = new ArrayList<Motivo>();
		motivos = this.motivoDAO.findAll();
		return motivos;
	}
	
}
