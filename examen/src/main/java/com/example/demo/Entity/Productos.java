package com.example.demo.Entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/*create table productos(
producto_id number primary key auto_increment,
orden_id number not null,
codigo varchar(20) not null,
descripcion varchar(200) not null,
precio decimal not null
)*/

@Entity
public class Productos {
	@Id
	@Column(name = "producto_id")
	private Long producto_id;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "precio")
	private Double precio;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="orden_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
    private Ordenes orden;
    
	public Productos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Productos(Long producto_id, String codigo, String descripcion, Double precio) {
		super();
		this.producto_id = producto_id;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public Long getProducto_id() {
		return producto_id;
	}

	public void setProducto_id(Long producto_id) {
		this.producto_id = producto_id;
	}


	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
	public Ordenes getOrden() {
		return orden;
	}

	public void setOrden(Ordenes orden) {
		this.orden = orden;
	}

	@Override
	public String toString() {
		return "Productos [producto_id=" + producto_id + ", codigo=" + codigo
				+ ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}

}
