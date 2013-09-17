package br.com.fiap.fiaproupasdelivery.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fiap.fiaproupasdelivery.controler.ProdutoRN;
import br.com.fiap.fiaproupasdelivery.entities.Produto;

@Path("/produto")
public class RestProduto {
	
	@GET
	@Path("/getproduto")
	@Produces(MediaType.APPLICATION_JSON)
	public Produto buscaProduto(@Context HttpHeaders headers){
		
		String token = headers.getRequestHeader("token").get(0).toString();
		
		if(RestEntregador.TEMPOTOKEN.containsKey(token)){
			Produto p = new Produto();
			ProdutoRN pro = new ProdutoRN();
			p = pro.buscarProduto((long)1);		
		return p;
		}else{
			return null;
		}
	}
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> buscaProdutos(@Context HttpHeaders headers){

		String token = headers.getRequestHeader("token").get(0).toString();
		
		if(RestEntregador.TEMPOTOKEN.containsKey(token)){
			List<Produto> produtos = new ArrayList<Produto>();
			ProdutoRN pro = new ProdutoRN();
			produtos = pro.buscarProdutos();
			return produtos;
		}else{
			return null;
		}
		
		
	}
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response recebeProduto(Produto e, @Context HttpHeaders headers){
		
		String token = headers.getRequestHeader("token").get(0).toString();
		
		if(RestEntregador.TEMPOTOKEN.containsKey(token)){
		
			ProdutoRN pro = new ProdutoRN();
			pro.salvar(e);
			
			String result = "Track saved : " + e;		
			return Response.status(201).entity(result).build();
		
		}else{
			String result = "Track unsaved : " + e;			
			return Response.status(202).entity(result).build();
		}
		
	}

}
