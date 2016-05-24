package br.edu.fjn.jpa.model.produto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "tb_cor")
public class Cor {
	@Id
	@Column(nullable= false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "genCor")
	@SequenceGenerator(name = "genCor", sequenceName="seqCor", initialValue= 1,
	allocationSize=1)
	private Integer id_cor;
	@Column(nullable= false)
	private String descricao;
	
	public Cor(){
		
	}
	
	public Integer getId_cor() {
		return id_cor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	 
}
