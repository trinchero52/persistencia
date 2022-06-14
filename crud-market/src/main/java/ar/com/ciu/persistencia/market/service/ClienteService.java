package ar.com.ciu.persistencia.market.service;

import java.util.List;

import ar.com.ciu.persistencia.market.dto.ClienteDTO;

public interface ClienteService {
	
	public ClienteDTO create(ClienteDTO clienteDTO);

	public ClienteDTO finById(Long idCliente);

	public List<ClienteDTO> finAll();
	
	public ClienteDTO update(ClienteDTO clienteDTO, Long id);
	
	public List<ClienteDTO> delete(Long idCliente);
	

}
