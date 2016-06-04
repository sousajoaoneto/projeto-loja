package br.edu.fjn.jpa.model.pedido;


import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.edu.fjn.jpa.model.usuario.Usuario;

@Entity(name = "tb_pedido")
public class Pedido {
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genPed")
	@SequenceGenerator(name = "genPed", sequenceName="seqPed", initialValue= 1,
	allocationSize=1)
	private Integer id_pedido;
	@Column(nullable = false)
	private Double valor_total;
	@JoinColumn(nullable=true, name="usuario_fk")
	@OneToOne(cascade = CascadeType.REFRESH)//ver novamente o cascade
	private Usuario usuario;
	@OneToMany(cascade = CascadeType.ALL)
	private List<ItemPedido> itemPedido;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date date = Date.from(Instant.now());
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Pagamento pagamento;
	
	public Pedido(){
		
	}
	
	public Pedido(Double valor_total, Usuario usuario, List<ItemPedido> itemPedido, Pagamento pagamento) {
		super();
		this.valor_total = valor_total;
		this.usuario = usuario;
		this.itemPedido = itemPedido;
		this.pagamento = pagamento;
	}

	public Integer getId_pedido() {
		return id_pedido;
	}
	
	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Double getValor_total() {
		return valor_total;
	}

	public void setValor_total(Double valor_total) {
		this.valor_total = valor_total;
	}
	
	

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	@Override
	public String toString() {
		return "Pedido [id_pedido=" + id_pedido + ", valor_total=" + valor_total + ", usuario=" + usuario.toString()
				+ ", itemPedido=" + itemPedido.toString() + "]";
	}
	
	
	
}
