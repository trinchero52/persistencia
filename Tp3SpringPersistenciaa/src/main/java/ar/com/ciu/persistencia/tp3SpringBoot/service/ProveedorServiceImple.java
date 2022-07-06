package ar.com.ciu.persistencia.tp3SpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ciu.persistencia.tp3SpringBoot.model.Proveedor;
import ar.com.ciu.persistencia.tp3SpringBoot.repository.ProveedorRepository;

@Service
public class ProveedorServiceImple implements ProveedorService{

	@Autowired
	private ProveedorRepository proveedorRepository;
	
	public  ProveedorServiceImple() {
		
	}
	
	@Override
	public Proveedor create(Proveedor proveedor) {
		Proveedor proveedor1 = new Proveedor(proveedor.getDescripcion());
		this.proveedorRepository.save(proveedor1);
		return proveedor1;
		
	}

}
