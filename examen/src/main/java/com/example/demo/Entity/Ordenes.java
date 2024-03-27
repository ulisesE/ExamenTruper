package com.example.demo.Entity;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/*create table ordenes(
orden_id number primary key auto_increment,
sucursal_id number not null,
fecha date not null,
total decimal not null,

)*/

@Entity
public class Ordenes {

	@Id
	@Column(name = "orden_id")
	private Long orden_id;
	
	@Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@Column(name = "total")
	private Double total;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="sucursal_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
    private Sucursales sucursal;
	
	@OneToMany(mappedBy="orden")
    private List<Productos> productos;
	
	public Ordenes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ordenes(Long orden_id, Date fecha, Double total) {
		super();
		this.orden_id = orden_id;
		this.fecha = fecha;
		this.total = total;
	}

	public Long getOrden_id() {
		return orden_id;
	}

	public void setOrden_id(Long orden_id) {
		this.orden_id = orden_id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	 
	public Sucursales getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursales sucursal) {
		this.sucursal = sucursal;
	}

	public List<Productos> getProductos() {
		return productos;
	}

	public void setProductos(List<Productos> list) {
		this.productos = list;
	}

	@Override
	public String toString() {
		return "Ordenes [orden_id=" + orden_id + ", fecha=" + fecha + ", total="
				+ total + "]";
	}

}
