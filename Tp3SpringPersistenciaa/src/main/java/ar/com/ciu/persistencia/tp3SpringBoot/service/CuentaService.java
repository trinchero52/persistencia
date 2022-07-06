package ar.com.ciu.persistencia.tp3SpringBoot.service;

import org.springframework.stereotype.Service;

import ar.com.ciu.persistencia.tp3SpringBoot.dto.CuentaDTO;

@Service
public interface CuentaService {
	public CuentaDTO create(CuentaDTO cuentaDTO);
}
