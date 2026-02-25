package com.imb2025.smedico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.imb2025.smedico.entity.MedioPago;
import com.imb2025.smedico.service.IMedioPagoService;

@RestController
public class MedioPagoController {
	
	@Autowired
	private IMedioPagoService service;

    MedioPagoController() {
    } 
    
    
	@GetMapping("/mediopago")
	public List<MedioPago> findAll() {
		 
		return service.findAll();
	}
	
	@GetMapping("/mediopago/{id}")
	public MedioPago findById(@PathVariable Long id) {
		
		return service.findById(id);
	}
	
	@PostMapping("/mediopago")
	public MedioPago create(@RequestBody MedioPago mediopago){ 
		
		return service.save(mediopago);
	}
	
	@PutMapping("/mediopago/{id}")
	public MedioPago update(@PathVariable Long id, @RequestBody MedioPago mediopago){
		
		MedioPago mpExistente = service.findById(id);
		
		if(mpExistente == null) {
			throw new RuntimeException("El regsitro de id "+ id + " no existe en la base de datos");
		}
		
		mpExistente.setNombre(mediopago.getNombre());
		mpExistente.setTipo(mediopago.getTipo());
		
		return service.save(mpExistente);
	}
	
	@DeleteMapping("/mediopago/{id}")
	public void delete(@PathVariable Long id){
		service.delete(id);
	}

}
