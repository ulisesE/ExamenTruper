package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entity.Productos;

public interface ProductosRepository extends CrudRepository<Productos, Long>{

}
