package com.example.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.example.demo.Entity.Ordenes;
import com.example.demo.Entity.Productos;
import com.example.demo.Entity.Sucursales;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ExamenApplicationTests {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	//@Test
	void contextLoads() {
	}
	
	@Test
	void post() throws ParseException {
	    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    Date date = dateFormat.parse("23/09/2007");

	    // Insertamos productos
	    Productos producto = new Productos(1L, "18156", "Esmeriladora angular", 625.00);
	    Productos producto2 = new Productos(2L, "17193", "Pala redonda", 100.50);

	    // Insertamos sucursal
	    Sucursales sucursal = new Sucursales(1L, "CDMX");

	    // Insertamos orden
	    Ordenes orden = new Ordenes(1L, date, 400.0);
	    orden.setSucursal(sucursal); // Asignamos la sucursal a la orden

	    // Asignamos productos a la orden
	    orden.setProductos(Arrays.asList(producto, producto2));

	    // Construimos el objeto que representa el cuerpo de la solicitud
	    Map<String, Object> requestBody = new HashMap<>();
	    requestBody.put("orden", orden);

	    // Realizamos la solicitud POST
	    ResponseEntity<String> response = restTemplate.postForEntity("/api/", requestBody, String.class);

	    // Verificamos el código de estado de la respuesta
	    HttpStatusCode statusCode = response.getStatusCode();
	    System.out.println("Status Code: " + statusCode);

	    // Si es necesario, también puedes imprimir el cuerpo de la respuesta
	    String responseBody = response.getBody();
	    System.out.println("Response Body: " + responseBody);
	}


}
