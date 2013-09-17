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

import br.com.fiap.fiaproupasdelivery.controler.ClienteRN;
import br.com.fiap.fiaproupasdelivery.entities.Cliente;

@Path("/cliente")
public class RestCliente {
	
	@GET
	@Path("/getcliente")
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente buscaCliente(long id, @Context HttpHeaders headers){
	
		String token = headers.getRequestHeader("token").get(0).toString();
		
		if(RestEntregador.TEMPOTOKEN.containsKey(token)){
		ClienteRN cr = new ClienteRN();		
		Cliente c = new Cliente();
		c = cr.buscarCliente((long)id);
		return c;
		}else{
			return null;
		}
	}
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> buscaClientes(@Context HttpHeaders headers){
		
		String token = headers.getRequestHeader("token").get(0).toString();
		
		if(RestEntregador.TEMPOTOKEN.containsKey(token)){
			List<Cliente> clientes = new ArrayList<Cliente>();
			ClienteRN cr = new ClienteRN();
			clientes = cr.buscarClientes();
			return clientes;
			}
		else{
			return null;
		}

		
	}
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response recebeClientes(Cliente c, @Context HttpHeaders headers){
		
		String token = headers.getRequestHeader("token").get(0).toString();
		
		if(RestEntregador.TEMPOTOKEN.containsKey(token)){
		ClienteRN crn = new ClienteRN();
		crn.salvar(c);
		String result = "Track saved : " + c;
			return Response.status(201).entity(result).build();
		}
		else{
		String result = "Track unsaved : " + c;
			return Response.status(202).entity(result).build();
		}
		
		
	}

}
