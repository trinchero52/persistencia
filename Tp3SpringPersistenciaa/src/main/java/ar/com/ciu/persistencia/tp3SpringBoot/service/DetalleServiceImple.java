package ar.com.ciu.persistencia.tp3SpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ciu.persistencia.tp3SpringBoot.dto.DetalleDTO;
import ar.com.ciu.persistencia.tp3SpringBoot.model.Detalle;
import ar.com.ciu.persistencia.tp3SpringBoot.repository.DetalleRepository;

@Service
public class DetalleServiceImple implements DetalleService{

	@Autowired
	private DetalleRepository detatalleRepository;
	
	public DetalleServiceImple() {
	}
	
	@Override
	
	public DetalleDTO create(DetalleDTO detalleDTO) {
		Detalle detalle = new Detalle(detalleDTO.getCantidad());
		this.detatalleRepository.save(detalle);
		return new DetalleDTO(detalle);
	}

}
