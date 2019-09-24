package br.com.fiap.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "Item", catalog = "dbportalecommerce")
@JsonIgnoreProperties(ignoreUnknown=true)
public class ItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public PedidoEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}

	public List<ProdutoEntity> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoEntity> produtos) {
		this.produtos = produtos;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Item_identificador", nullable = false)
	private Integer identificador;

	@Column(name = "quantidade")
	private double quantidade;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "Pedido_identificador", referencedColumnName = "Pedido_identificador") })
	private PedidoEntity pedido;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "Item_Produto", catalog = "dbportalecommerce", joinColumns = {
			@JoinColumn(name = "Item_identificador", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "Produto_identificador", nullable = false, updatable = false) })
	private List<ProdutoEntity> produtos;

}
