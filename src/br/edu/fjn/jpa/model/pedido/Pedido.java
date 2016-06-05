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
	@JoinColumn(nullable=false, name="usuario_fk")
	@OneToOne(cascade = CascadeType.REFRESH)//ver novamente o cascade
	private Usuario usuario;
	@OneToMany(cascade = CascadeType.ALL)
	private List<ItemPedido> itemPedido;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date date = Date.from(Instant.now());
	@JoinColumn(nullable=false, name="pagamento_fk")
	@OneToOne(cascade = CascadeType.PERSIST)
	private Pagamento pagamento;
	@JoinColumn(nullable=false, name="entrega_fk")
	@OneToOne(cascade = CascadeType.PERSIST)
	private Entrega entrega;
	
	public Pedido(){
		
	}
	
	public Pedido(Double valor_total, Usuario usuario, List<ItemPedido> itemPedido, Pagamento pagamento,
			Entrega entrega) {
		super();
		this.valor_total = valor_total;
		this.usuario = usuario;
		this.itemPedido = itemPedido;
		this.pagamento = pagamento;
		this.entrega = entrega;
	}

	public void setId_pedido(Integer id_pedido) {
		this.id_pedido = id_pedido;
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

	public Date getDate() {
		return date;
	}

	public Entrega getEntrega() {
		return entrega;
	}

	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}

	@Override
	public String toString() {
		return "Pedido [id_pedido=" + id_pedido + ", valor_total=" + valor_total + ", usuario=" + usuario.toString()
				+ ", itemPedido=" + itemPedido.toString() + ", date=" + date + ", pagamento=" + pagamento.toString() + ", entrega=" + entrega.toString()
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((entrega == null) ? 0 : entrega.hashCode());
		result = prime * result + ((id_pedido == null) ? 0 : id_pedido.hashCode());
		result = prime * result + ((itemPedido == null) ? 0 : itemPedido.hashCode());
		result = prime * result + ((pagamento == null) ? 0 : pagamento.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((valor_total == null) ? 0 : valor_total.hashCode());
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
		Pedido other = (Pedido) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (entrega == null) {
			if (other.entrega != null)
				return false;
		} else if (!entrega.equals(other.entrega))
			return false;
		if (id_pedido == null) {
			if (other.id_pedido != null)
				return false;
		} else if (!id_pedido.equals(other.id_pedido))
			return false;
		if (itemPedido == null) {
			if (other.itemPedido != null)
				return false;
		} else if (!itemPedido.equals(other.itemPedido))
			return false;
		if (pagamento == null) {
			if (other.pagamento != null)
				return false;
		} else if (!pagamento.equals(other.pagamento))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (valor_total == null) {
			if (other.valor_total != null)
				return false;
		} else if (!valor_total.equals(other.valor_total))
			return false;
		return true;
	}

		
	
	
}
