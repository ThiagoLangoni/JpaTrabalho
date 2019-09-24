package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Pedido", catalog = "dbportalecommerce")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PedidoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public Date getDatapedido() {
		return datapedido;
	}

	public void setDatapedido(Date datapedido) {
		this.datapedido = datapedido;
	}

	public List<ItemEntity> getItens() {
		return itens;
	}

	public void setItens(List<ItemEntity> itens) {
		this.itens = itens;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Pedido_identificador", nullable = false)
	private Integer identificador;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Cliente_identificador")
	private ClienteEntity cliente;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "datapedido", nullable = false)
	private Date datapedido;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "pedido")
	private List<ItemEntity> itens;

}
