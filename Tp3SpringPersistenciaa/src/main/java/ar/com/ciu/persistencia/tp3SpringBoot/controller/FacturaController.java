package ar.com.ciu.persistencia.tp3SpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ciu.persistencia.tp3SpringBoot.dto.FacturaDTO;
import ar.com.ciu.persistencia.tp3SpringBoot.model.Producto;
import ar.com.ciu.persistencia.tp3SpringBoot.service.FacturaService;

@RestController
@RequestMapping("/factura")
public class FacturaController {
	@Autowired
	private FacturaService facturaService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<FacturaDTO> create(@RequestBody FacturaDTO facturaDTO, @RequestBody Producto prod, @RequestBody int cant){  // metodo que me devuelve un objeto ClienteDTO
		facturaDTO = this.facturaService.create(facturaDTO, prod, cant);
		return new ResponseEntity<FacturaDTO>(facturaDTO, HttpStatus.CREATED);		// El objeto fue creado exitosamente
	}
}
