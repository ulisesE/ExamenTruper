package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

/*
 * create table sucursales( 
 * sucursal_id number primary key auto_increment,
 * nombre varchar(50) not null )
 */

@Entity
public class Sucursales {
	@Id
	@Column(name = "sucursal_id")
	private Long sucursal_id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "sucursal")
    private List<Ordenes> ordenes;

	public Sucursales() {
		super();
		ordenes=new ArrayList<Ordenes>();
		// TODO Auto-generated constructor stub
	}

	public Sucursales(Long sucursal_id, String nombre) {
		super();
		this.sucursal_id = sucursal_id;
		this.nombre = nombre;
	}

	public Long getSucursal_id() {
		return sucursal_id;
	}

	public void setSucursal_id(Long sucursal_id) {
		this.sucursal_id = sucursal_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public List<Ordenes> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(List<Ordenes> ordenes) {
		this.ordenes = ordenes;
	}

	@Override
	public String toString() {
		return "Sucursales [sucursal_id=" + sucursal_id + ", nombre=" + nombre + "]";
	}

}
