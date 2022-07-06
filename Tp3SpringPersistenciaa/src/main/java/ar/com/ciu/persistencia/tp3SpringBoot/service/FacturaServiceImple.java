package ar.com.ciu.persistencia.tp3SpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ciu.persistencia.tp3SpringBoot.dto.FacturaDTO;
import ar.com.ciu.persistencia.tp3SpringBoot.model.Factura;
import ar.com.ciu.persistencia.tp3SpringBoot.model.Producto;
import ar.com.ciu.persistencia.tp3SpringBoot.repository.FacturaRepository;

@Service
public class FacturaServiceImple implements FacturaService{

	@Autowired
	private FacturaRepository facturaRepository;
	
	public FacturaServiceImple() {
	}
	
	@Override
	public FacturaDTO create(FacturaDTO facturaDTO, Producto prod, int cant) {
		Factura factura = new Factura(facturaDTO.getFecha(), facturaDTO.getNumero());
		factura.agregarDetalle(prod, cant);
		this.facturaRepository.save(factura);
		return new FacturaDTO(factura);
	}

	
	
}
