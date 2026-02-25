package com.imb2025.smedico.service.jpa;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.smedico.dto.MedioPagoRequestDTO;
import com.imb2025.smedico.entity.MedioPago;
import com.imb2025.smedico.repository.MedioPagoRepository;
import com.imb2025.smedico.service.IMedioPagoService;


@Service
public class MedioPagoServiceImpl implements IMedioPagoService {

	@Autowired
	private MedioPagoRepository repo;
	
	@Override
	public List<MedioPago> findAll(){
		return repo.findAll();
	}
	
	@Override
	public MedioPago findById(Long id) {
		Optional <MedioPago> optMp= repo.findById(id);
		
		if(optMp.isPresent()) {
			return optMp.get();
		}else {
			return null;
		}
	}
	
	@Override
	public MedioPago save(MedioPago mediopago) {
		return repo.save(mediopago); //llame al metodo de crudrepository() no al mas completo de jparepository porque ahora solo necesito las operaciones basicas
	}
	
	@Override
	public MedioPago update(Long id, MedioPago mediopago) throws Exception {
	
		if(repo.existsById(id)){
			mediopago.setId(id);
			return repo.save(mediopago);
		}else {
			throw new Exception("Medio de pago de id: "+ id +" No encontrado!");
		}
	}	
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}

	@Override
	public MedioPago crearMedioPago(MedioPagoRequestDTO dtor) throws Exception{ 
		
		if(dtor.getNombre() == null || dtor.getNombre().isBlank() ) {
			throw new IllegalArgumentException("El campo Nombre esta vacio. Ingrese un valor");
			
		}if(dtor.getTipo() == null || dtor.getTipo().toString().isBlank()) {
			throw new IllegalArgumentException("El campo Tipo esta vacio. Ingrese un valor");
		}
		MedioPago mediopago = new MedioPago();
		mediopago.setNombre(dtor.getNombre());
		mediopago.setTipo(dtor.getTipo());
		
		return mediopago; 
	}

}
