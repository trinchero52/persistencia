package ar.com.ciu.persistencia.tp3SpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ciu.persistencia.tp3SpringBoot.model.General;
import ar.com.ciu.persistencia.tp3SpringBoot.repository.ProductoRepository;

@Service
public class ProductoServiceImple implements ProductoService{

	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public General create(General general) {
		General general1 = new General(general.getCodigo(), general.getDescripcion(), general.getPeso());
		this.productoRepository.save(general1);
		return general1;
	}
	
	
}
