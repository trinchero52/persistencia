package ar.com.ciu.persistencia.tp3SpringBoot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.com.ciu.persistencia.tp3SpringBoot.dto.ClienteDTO;

@Service
public interface ClienteService {
	
	public ClienteDTO create(ClienteDTO clienteDTO);

	public ClienteDTO finById(Long idCliente);

	public List<ClienteDTO> finAll();

	public ClienteDTO update(ClienteDTO clienteDTO, Long id);
	
	public List<ClienteDTO> delete(Long idCliente);
	

}
