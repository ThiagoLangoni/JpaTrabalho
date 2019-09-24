package br.com.fiap.entity;

import java.io.Serializable;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "Produto", catalog = "dbportalecommerce")
@JsonIgnoreProperties(ignoreUnknown=true)
public class ProdutoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQuantidade_total_estoque() {
		return quantidade_total_estoque;
	}

	public void setQuantidade_total_estoque(Integer quantidade_total_estoque) {
		this.quantidade_total_estoque = quantidade_total_estoque;
	}

	public List<ItemEntity> getItens() {
		return itens;
	}

	public void setItens(List<ItemEntity> itens) {
		this.itens = itens;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Produto_identificador", nullable = false)
	private Integer identificador;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Column(name = "valor", nullable = false)
	private Double valor;

	@Column(name = "quantidade_total_estoque", nullable = false)
	private Integer quantidade_total_estoque;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "produtos")
	private List<ItemEntity> itens;
}
