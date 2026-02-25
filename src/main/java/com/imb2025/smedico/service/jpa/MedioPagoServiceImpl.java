package com.imb2025.smedico.service.jpa;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
		Optional <MedioPago> opt= repo.findById(id);
		
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
	@Override
	public MedioPago save(MedioPago mediopago) {
		return repo.save(mediopago); //llame al metodo de crudrepository() no al mas completo de jparepository porque ahora solo necesito las operaciones basicas
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
