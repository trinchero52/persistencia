package ar.com.ciu.persistencia.tp3SpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ciu.persistencia.tp3SpringBoot.dto.DetalleDTO;
import ar.com.ciu.persistencia.tp3SpringBoot.service.DetalleService;

@RestController
@RequestMapping("/detalle")
public class DetalleCotroller {
	
	@Autowired
	private DetalleService detalleService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<DetalleDTO> create(@RequestBody DetalleDTO detalleDTO){  // metodo que me devuelve un objeto ClienteDTO
		detalleDTO = this.detalleService.create(detalleDTO);
		return new ResponseEntity<DetalleDTO>(detalleDTO, HttpStatus.CREATED);		// El objeto fue creado exitosamente
	}
}