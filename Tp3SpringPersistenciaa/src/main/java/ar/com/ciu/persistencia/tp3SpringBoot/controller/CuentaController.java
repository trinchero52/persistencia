package ar.com.ciu.persistencia.tp3SpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ciu.persistencia.tp3SpringBoot.dto.CuentaDTO;
import ar.com.ciu.persistencia.tp3SpringBoot.service.CuentaService;

@RestController
@RequestMapping("/cuenta")	
public class CuentaController {

	@Autowired
	private CuentaService cuentaService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<CuentaDTO> create(@RequestBody CuentaDTO cuentaDTO){  // metodo que me devuelve un objeto ClienteDTO
		cuentaDTO = this.cuentaService.create(cuentaDTO);
		return new ResponseEntity<CuentaDTO>(cuentaDTO, HttpStatus.CREATED);		// El objeto fue creado exitosamente
	}
}
