package ar.com.ciu.persistencia.tp3SpringBoot.service;

import org.springframework.stereotype.Service;

import ar.com.ciu.persistencia.tp3SpringBoot.dto.FacturaDTO;
import ar.com.ciu.persistencia.tp3SpringBoot.model.Producto;

@Service
public interface FacturaService {
	public FacturaDTO create(FacturaDTO FacturaDTO, Producto prod, int cant);
}
