package ar.com.ciu.persistencia.market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import ar.com.ciu.persistencia.market.dto.ClienteDTO;
import ar.com.ciu.persistencia.market.service.ClienteService;

@RestController
@RequestMapping("/cliente")				// para indicar que el acceso es por /cliente
public class ClientController {
	
	// atributos
	@Autowired
	private ClienteService clienteService;

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO clienteDTO){  // metodo que me devuelve un objeto ClienteDTO
		clienteDTO = this.clienteService.create(clienteDTO);
		return new ResponseEntity<ClienteDTO>(clienteDTO, HttpStatus.CREATED);		// El objeto fue creado exitosamente
	}
	
	@RequestMapping(value="/findById/{id}", method=RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<ClienteDTO> findByID(@PathVariable("id") long id) throws NotFoundException{
		ClienteDTO clienteDto = this.clienteService.finById(id);
		if(clienteDto == null) {
			throw new NotFoundException();
		}
		return new ResponseEntity<ClienteDTO>(clienteDto, HttpStatus.OK);
	}
	
	@RequestMapping(value="/findAll", method=RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<ClienteDTO>> findAll() throws NotFoundException{
		List<ClienteDTO> clientesDto = this.clienteService.finAll();
		if(clientesDto.size() == 0) {
			throw new NotFoundException();
		}
		return new ResponseEntity<List<ClienteDTO>>(clientesDto, HttpStatus.OK);
	}
	
	@RequestMapping(value="/update/{id}" ,method=RequestMethod.PUT)
	//@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<ClienteDTO> updateById(@RequestBody ClienteDTO cli, @PathVariable("id") Long id) throws NotFoundException{
		ClienteDTO clienteDto = this.clienteService.update(cli, id);
		if(clienteDto == null) {
			throw new NotFoundException();
		}
		return new ResponseEntity<ClienteDTO>(clienteDto, HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete/{id}" ,method=RequestMethod.DELETE)
	//@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<ClienteDTO>> deleteById(@PathVariable Long id) throws NotFoundException {
		List<ClienteDTO> clienteDto = this.clienteService.delete(id);
		if(clienteDto == null) {
			throw new NotFoundException();
		}
		return new ResponseEntity<List<ClienteDTO>>(clienteDto, HttpStatus.OK);
	}
	
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Void> exceptionHandler(Exception excep){
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
