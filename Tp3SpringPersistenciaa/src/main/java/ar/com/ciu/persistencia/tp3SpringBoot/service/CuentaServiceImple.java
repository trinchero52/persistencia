package ar.com.ciu.persistencia.tp3SpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ciu.persistencia.tp3SpringBoot.dto.CuentaDTO;
import ar.com.ciu.persistencia.tp3SpringBoot.model.Cuenta;
import ar.com.ciu.persistencia.tp3SpringBoot.repository.CuentaRepository;

@Service
public class CuentaServiceImple implements CuentaService{

	@Autowired
	private CuentaRepository cuentaRepository;
	
	public CuentaServiceImple() {
		
	};
	
	@Override
	public CuentaDTO create(CuentaDTO cuentaDTO) {
		Cuenta cta = new Cuenta(
				cuentaDTO.getNumero());
		this.cuentaRepository.save(cta);
		return new CuentaDTO(cta);
	}

}
