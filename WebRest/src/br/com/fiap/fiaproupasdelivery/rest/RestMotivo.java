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

import br.com.fiap.fiaproupasdelivery.controler.MotivoRN;
import br.com.fiap.fiaproupasdelivery.entities.Motivo;

@Path("/motivo")
public class RestMotivo {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Motivo> buscaMotivos(@Context HttpHeaders headers){
		
		String token = headers.getRequestHeader("token").get(0).toString();
		
		if(RestEntregador.TEMPOTOKEN.containsKey(token)){
		List<Motivo> motivos = new ArrayList<Motivo>();
		MotivoRN moRN = new MotivoRN();
		motivos = moRN.buscarMotivos();
		return motivos;
		}else{
			return null;
		}
	}
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response recebeMotivo(Motivo e, @Context HttpHeaders headers){
		
		String token = headers.getRequestHeader("token").get(0).toString();
	
		if(RestEntregador.TEMPOTOKEN.containsKey(token)){
		
			MotivoRN motivoRN = new MotivoRN();
			motivoRN.salvar(e);
			String result = "Track saved : " + e;
		return Response.status(201).entity(result).build();
		}else{
			String result = "Track unsaved : " + e;
			return Response.status(202).entity(result).build();
		}
	}
	
}
