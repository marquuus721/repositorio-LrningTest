package com.imb2025.smedico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imb2025.smedico.dto.MedioPagoRequestDTO;
import com.imb2025.smedico.entity.MedioPago;
import com.imb2025.smedico.service.IMedioPagoService;

@RestController
public class MedioPagoController {
	
	@Autowired
	private IMedioPagoService service;

    MedioPagoController() {
    } 
    
    
	@GetMapping("/mediopago")
	public ResponseEntity<List<MedioPago>> findAll() {
		List <MedioPago> mediopago = service.findAll();
		if (mediopago.isEmpty()){
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(mediopago);
		}
	}
	
	@GetMapping("/mediopago/{id}")
	public ResponseEntity<MedioPago> findById(@PathVariable Long id) {
		MedioPago mediopago = service.findById(id);
		
		if (mediopago == null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(mediopago);
		}
	}
	
	@PostMapping("/mediopago")
	public ResponseEntity<MedioPago> create(@RequestBody MedioPagoRequestDTO dtor) throws Exception{ 
		
		return ResponseEntity.ok(service.save(service.crearMedioPago(dtor)));
	}
	
	@PutMapping("/mediopago/{id}")
	public ResponseEntity<MedioPago> update(@PathVariable Long id, @RequestBody MedioPagoRequestDTO dtor) throws Exception{
		
		return ResponseEntity.ok(service.update(id, service.crearMedioPago(dtor)));
	}
	
	@DeleteMapping("/mediopago/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) throws Exception{
		service.deleteById(id);
		return ResponseEntity.ok("El Medio de Pago de id "+ id +" fue eliminado de la tabla MedioDePago exitosamente!");
	}

	@ExceptionHandler (Exception.class)
	public ResponseEntity<String> handleExceptionDe400(Exception except){
		//except.printStackTrace();
		return ResponseEntity.badRequest().body(except.getMessage());
	}

}
