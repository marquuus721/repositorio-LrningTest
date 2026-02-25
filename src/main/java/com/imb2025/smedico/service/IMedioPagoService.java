package com.imb2025.smedico.service;

import java.util.List;
import com.imb2025.smedico.entity.MedioPago;


public interface IMedioPagoService {

	public List<MedioPago> findAll();
	public MedioPago findById(Long id);
	public MedioPago save(MedioPago mediopago);
	public void delete(Long id);
}
