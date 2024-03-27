package com.example.demo.Constroller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Ordenes;
import com.example.demo.Entity.Productos;
import com.example.demo.Entity.Sucursales;
import com.example.demo.Repository.OrdenesRepository;
import com.example.demo.Repository.ProductosRepository;
import com.example.demo.Repository.SucursalesRepository;

@Controller
@RequestMapping("/api")
public class MainController {
	
	Logger logger = LoggerFactory.getLogger(MainController.class);

	
	@Autowired
	OrdenesRepository ordenesRepositoryImp;
	@Autowired
	SucursalesRepository sucursalesRepositoryImp;
	@Autowired
	ProductosRepository productosRepositoryImp;
	
	@GetMapping("/{requestOrderId}")
	public ResponseEntity<String> getById(@RequestParam Long requestOrderId){
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/")
	public ResponseEntity<String> createOrder(@RequestBody Ordenes orden) {
	    // Guardar la orden y sus productos en la base de datos
	    try {
	        // Guardar la sucursal de la orden en caso de que no exista en la base de datos
	        Sucursales sucursal = orden.getSucursal();
	        if (sucursal != null) {
	            sucursalesRepositoryImp.save(sucursal);
	        }

	        // Guardar la orden en la base de datos
	        ordenesRepositoryImp.save(orden);

	        // Guardar los productos asociados a la orden en la base de datos
	        List<Productos> productos = orden.getProductos();
	        if (productos != null && !productos.isEmpty()) {
	            productosRepositoryImp.saveAll(productos);
	        }

	        // Operación exitosa, devolver un mensaje de éxito
	        return new ResponseEntity<>("Order created successfully", HttpStatus.OK);
	    } catch (Exception e) {
	        // En caso de algún error, devolver un mensaje de error y un código de estado apropiado
	        return new ResponseEntity<>("Failed to create order: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}


	

}
