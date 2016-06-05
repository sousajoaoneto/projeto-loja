package br.edu.fjn.jpa.model.pedido;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "tb_pagamento")
public class Pagamento {
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genPag")
	@SequenceGenerator(name = "genPag", sequenceName="seqPag", initialValue= 1,
	allocationSize=1)
	private Integer id_pagamento;
	@Column(nullable = false)
	private boolean status_pagamento;
	@Column(nullable = false)
	private FormaPagamento forma_pagamento;
	@Column(nullable = false)
	private Integer parcelamento;
		
	public Pagamento(){
		
	}
	
	public Pagamento(boolean status_pagamento, FormaPagamento forma_pagamento, Integer parcelamento) {
		super();
		this.status_pagamento = status_pagamento;
		this.forma_pagamento = forma_pagamento;
		this.parcelamento = parcelamento;
	}

	public void setId_pagamento(Integer id_pagamento) {
		this.id_pagamento = id_pagamento;
	}

	public Integer getId_pagamento() {
		return id_pagamento;
	}
	
	public boolean isStatus_pagamento() {
		return status_pagamento;
	}

	public void setStatus_pagamento(boolean status_pagamento) {
		this.status_pagamento = status_pagamento;
	}

	public FormaPagamento getForma_pagamento() {
		return forma_pagamento;
	}

	public void setForma_pagamento(FormaPagamento forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}

	public Integer getParcelamento() {
		return parcelamento;
	}

	public void setParcelamento(Integer parcelamento) {
		this.parcelamento = parcelamento;
	}

	@Override
	public String toString() {
		return "Pagamento [id_pagamento=" + id_pagamento + ", status_pagamento=" + status_pagamento
				+ ", forma_pagamento=" + forma_pagamento + ", parcelamento=" + parcelamento + "]";
	}

	//hash and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((forma_pagamento == null) ? 0 : forma_pagamento.hashCode());
		result = prime * result + ((id_pagamento == null) ? 0 : id_pagamento.hashCode());
		result = prime * result + ((parcelamento == null) ? 0 : parcelamento.hashCode());
		result = prime * result + (status_pagamento ? 1231 : 1237);
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
		Pagamento other = (Pagamento) obj;
		if (forma_pagamento != other.forma_pagamento)
			return false;
		if (id_pagamento == null) {
			if (other.id_pagamento != null)
				return false;
		} else if (!id_pagamento.equals(other.id_pagamento))
			return false;
		if (parcelamento == null) {
			if (other.parcelamento != null)
				return false;
		} else if (!parcelamento.equals(other.parcelamento))
			return false;
		if (status_pagamento != other.status_pagamento)
			return false;
		return true;
	}	
	
	
}
