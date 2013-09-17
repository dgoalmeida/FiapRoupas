package br.com.fiap.fiaproupasdelivery.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Validacao {

	private String token;
	private String user;
	private String pass;
	
	public Validacao(){}
	
	public Validacao(String token){
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	
	
	
}
