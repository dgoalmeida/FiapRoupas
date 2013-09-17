package br.com.fiap.fiaproupasdelivery.util;

import br.com.fiap.fiaproupasdelivery.dao.ClienteDAO;
import br.com.fiap.fiaproupasdelivery.dao.EntregaDAO;
import br.com.fiap.fiaproupasdelivery.dao.EntregadorDAO;
import br.com.fiap.fiaproupasdelivery.dao.GenericDAO;
import br.com.fiap.fiaproupasdelivery.dao.GenericEntregador;
import br.com.fiap.fiaproupasdelivery.dao.MotivoDAO;
import br.com.fiap.fiaproupasdelivery.dao.ProdutoDAO;
import br.com.fiap.fiaproupasdelivery.entities.Cliente;
import br.com.fiap.fiaproupasdelivery.entities.Entrega;
import br.com.fiap.fiaproupasdelivery.entities.Entregador;
import br.com.fiap.fiaproupasdelivery.entities.Motivo;
import br.com.fiap.fiaproupasdelivery.entities.Produto;

public class DaoFactory {

	public static GenericDAO<Cliente, Long> criarClienteDAO(){
		ClienteDAO cliente = new ClienteDAO();
		cliente.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return cliente;
	}
	
	public static GenericEntregador<Entregador, Long> criarEntregadorDAO(){
		EntregadorDAO entregador = new EntregadorDAO();
		entregador.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return entregador;
	}
	
	public static GenericDAO<Produto, Long> criarProdutoDAO(){
		ProdutoDAO produto = new ProdutoDAO();
		produto.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return produto;
	}
	
	public static GenericDAO<Motivo, Long> criarMotivoDAO(){
		MotivoDAO motivo = new MotivoDAO();
		motivo.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return motivo;
	}
	
	public static GenericDAO<Entrega, Long> criarEntregaDAO(){
		EntregaDAO entrega = new EntregaDAO();
		entrega.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return entrega;
	}
}
