package br.edu.fjn.jpa.model.pedido;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;


@Entity(name = "tb_entrega")
public class Entrega {
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genEntrega")
	@SequenceGenerator(name = "genEntrega", sequenceName="seqEntrega", initialValue= 1,
	allocationSize=1)
	private Integer id_entrega;
	@Column(nullable = false)
	private String status_entrega;
	@JoinColumn(nullable = false, name = "pedido_fk")
	@OneToOne(cascade = CascadeType.ALL) 
	private Pedido pedido;
	
	public Entrega(){
		
	}
	

	public String getStatus_entrega() {
		return status_entrega;
	}

	public void setStatus_entrega(String status_entrega) {
		this.status_entrega = status_entrega;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Integer getId_entrega() {
		return id_entrega;
	}	
	
}
