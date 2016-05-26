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
	
	@JoinColumn(nullable=false, name="pedido_fk")
	@OneToOne
	private Pedido pedido;
	
	public Pagamento(){
		
	}
	
	public Pagamento(boolean status_pagamento, FormaPagamento forma_pagamento, Integer parcelamento, Pedido pedido) {
		super();
		this.status_pagamento = status_pagamento;
		this.forma_pagamento = forma_pagamento;
		this.parcelamento = parcelamento;
		this.pedido = pedido;
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

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	
	
}
