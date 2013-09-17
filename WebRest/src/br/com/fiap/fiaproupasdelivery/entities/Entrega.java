package br.com.fiap.fiaproupasdelivery.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Entrega implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cod;
	
	private String dataentrega;

	private String status;

	private String motivo;
	
	private String receptador;

	private byte[] evidencia;


	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	 @JoinColumn(name="cod_cliente")
	private Cliente cliente;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	 @JoinColumn(name="cod_entregador")
	private Entregador entregador;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	 @JoinColumn(name="cod_produto")
	private Produto produto;

	public Entrega() {
	}

	public Long getCod() {
		return cod;
	}

	public void setCod(Long cod) {
		this.cod = cod;
	}

	public String getDataentrega() {
		return dataentrega;
	}

	public void setDataentrega(String dataentrega) {
		this.dataentrega = dataentrega;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Entregador getEntregador() {
		return entregador;
	}

	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getReceptador() {
		return receptador;
	}

	public void setReceptador(String receptador) {
		this.receptador = receptador;
	}

	public byte[] getEvidencia() {
		return evidencia;
	}

	public void setEvidencia(byte[] evidencia) {
		this.evidencia = evidencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod == null) ? 0 : cod.hashCode());
		result = prime * result + ((dataentrega == null) ? 0 : dataentrega.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrega other = (Entrega) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		if (dataentrega == null) {
			if (other.dataentrega != null)
				return false;
		} else if (!dataentrega.equals(other.dataentrega))
			return false;
		return true;
	}
}