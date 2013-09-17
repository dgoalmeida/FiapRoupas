package br.com.fiap.fiaproupasdelivery.controler;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fiaproupasdelivery.dao.GenericDAO;
import br.com.fiap.fiaproupasdelivery.entities.Cliente;
import br.com.fiap.fiaproupasdelivery.util.DaoFactory;

public class ClienteRN {

	public GenericDAO<Cliente, Long> clienteDAO;
	
	public ClienteRN(){
		clienteDAO = DaoFactory.criarClienteDAO();
	}
	
	public boolean salvar(Cliente c){
		
		boolean retorno = this.clienteDAO.create(c);
		
		return retorno;
	}
	
	public Cliente buscarCliente(Long id){
		
		Cliente c = new Cliente();
		c = this.clienteDAO.findById(id);
		return c;
	}
	
	public List<Cliente> buscarClientes(){
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes = this.clienteDAO.findAll();
		
		return clientes;
	}
}
