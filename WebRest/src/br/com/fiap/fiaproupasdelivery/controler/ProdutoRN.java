package br.com.fiap.fiaproupasdelivery.controler;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fiaproupasdelivery.dao.GenericDAO;
import br.com.fiap.fiaproupasdelivery.entities.Produto;
import br.com.fiap.fiaproupasdelivery.util.DaoFactory;

public class ProdutoRN {

	public GenericDAO<Produto, Long> produtoDAO;
	
	public ProdutoRN(){
		produtoDAO = DaoFactory.criarProdutoDAO();
	}
	
	public boolean salvar(Produto p){
		
		boolean retorno = this.produtoDAO.create(p);
		
		return retorno;
	}
	
	public boolean alterar(Produto p){

		boolean retorno = this.produtoDAO.update(p);
		
		return retorno;
	}
	
	public boolean excluir(Produto p){

		boolean retorno = this.produtoDAO.delete(p);
		
		return retorno;
	}
	
	public Produto buscarProduto(Long id){
		
		Produto p = new Produto();
		
		p = this.produtoDAO.findById(id);
		
		return p;
	}
	
	public List<Produto> buscarProdutos(){
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		produtos = this.produtoDAO.findAll();
		
		return produtos;
	}
}
