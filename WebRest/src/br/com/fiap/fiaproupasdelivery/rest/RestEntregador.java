package br.com.fiap.fiaproupasdelivery.rest;

import java.util.Date;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fiap.fiaproupasdelivery.controler.EntregadorRN;
import br.com.fiap.fiaproupasdelivery.entities.Entregador;
import br.com.fiap.fiaproupasdelivery.entities.Validacao;

@Path("/entregador")
public class RestEntregador {
	
	public static HashMap<String, Date > TEMPOTOKEN = new HashMap<>();

	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Entregador buscaEntregador(@Context HttpHeaders headers){
		
		String token = headers.getRequestHeader("token").get(0).toString();
		
		if(RestEntregador.TEMPOTOKEN.containsKey(token)){
		EntregadorRN enRn = new EntregadorRN();		
		String user = headers.getRequestHeader("user").get(0).toString();
		String pass = headers.getRequestHeader("pass").get(0).toString();
		Entregador e = new Entregador();
		e = enRn.loginEntregador(user, pass);
		
		return e;
		}
		else{
			return null;
		}
		
		
	}
	
	
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response recebeEntregador(Entregador e, @Context HttpHeaders headers){
		
		String token = headers.getRequestHeader("token").get(0).toString();
		
		if(RestEntregador.TEMPOTOKEN.containsKey(token)){		
		String result = "Track saved : " + e;		
		EntregadorRN enRn = new EntregadorRN();
		enRn.salvar(e);
		return Response.status(201).entity(result).build();
		}else{
			return Response.status(202).build();
		}
	}
	
	@GET
	@Path("/getlogin")
	@Produces(MediaType.APPLICATION_JSON)
	public Validacao loginEntregador(@Context HttpHeaders headers){
		
		
		EntregadorRN enRn = new EntregadorRN();
		Entregador e = new Entregador();
		
		String user = headers.getRequestHeader("user").get(0).toString();
		String pass = headers.getRequestHeader("pass").get(0).toString();
		
		e = enRn.loginEntregador(user, pass);
		String token = String.valueOf("a"+e.getCod() + e.hashCode()); 
		
		System.out.println("token: "+token);
		
		Validacao t = new Validacao();
		
		if(!TEMPOTOKEN.containsKey(token)){
			
		TEMPOTOKEN.put(token, new Date());		
		
		t.setToken(token);
		t.setUser(user);
		t.setPass(pass);
	}
		
		return t;
	}
}
