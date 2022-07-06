package ar.com.ciu.persistencia.tp3SpringBoot.service;

import org.springframework.stereotype.Service;

import ar.com.ciu.persistencia.tp3SpringBoot.dto.DetalleDTO;

@Service
public interface DetalleService {
	public DetalleDTO create(DetalleDTO detalleDTO);
}
