package ar.com.ciu.persistencia.tp3SpringBoot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ciu.persistencia.tp3SpringBoot.dto.*;
import ar.com.ciu.persistencia.tp3SpringBoot.model.*;
import ar.com.ciu.persistencia.tp3SpringBoot.repository.*;

@Service
public class ClientServiceImpl implements ClienteService{

	//atributos
	@Autowired
	private ClienteRepository clienteRepository;
	
	
//	@Autowired
//	private CuentaRepository cuentaRepository;
	
	public ClientServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	// metodos
	@Override
	public ClienteDTO create(ClienteDTO clienteDTO) {
		Cliente cli1 = new Cliente(
				clienteDTO.getCodigo(),
				clienteDTO.getApellido(),
				clienteDTO.getNombre());
		this.clienteRepository.save(cli1);
		System.out.println(cli1.toString());
		return new ClienteDTO(cli1);
	}

	@Override
	public ClienteDTO finById(Long idCliente) {
		Cliente cliente = this.clienteRepository.findById(idCliente).orElse(null);
		ClienteDTO clienteDto = null;
		if(cliente !=null) {
			clienteDto = new ClienteDTO(cliente);
		}
		return clienteDto;
	}
	
	@Override
	public List<ClienteDTO> finAll() {
		List<Cliente> clientes = (List<Cliente>) this.clienteRepository.findAll();
		List<ClienteDTO> clientesDto = new ArrayList<ClienteDTO>();
		if(clientes != null) {
			clientes.forEach(c -> clientesDto.add(new ClienteDTO(c)));
		}
		return clientesDto;
	}

	@Override
	public ClienteDTO update(ClienteDTO clienteDTO, Long id) {
		List<Cliente> clientes =  (List<Cliente>) this.clienteRepository.findAll();
		Cliente clienteId = clientes.stream().filter(c -> c.getId().equals(id)).findAny().orElse(null);
		if(clienteDTO == null) {
			return null;
		}
		if(clienteDTO.getApellido() != null) {
		clienteId.setApellido(clienteDTO.getApellido());
		}
		if(clienteDTO.getCodigo() != null) {
		clienteId.setCodigo(clienteDTO.getCodigo());
		}
		if(clienteDTO.getNombre() != null) {
		clienteId.setNombre(clienteDTO.getNombre());
		}
		
		this.clienteRepository.save(clienteId);
		
		return new ClienteDTO(clienteId);
	}

	@Override
	public List<ClienteDTO> delete(Long idCliente) {
		List<Cliente> clientes = (List<Cliente>) this.clienteRepository.findAll();
		Cliente clienteid = clientes.stream().filter(c -> c.getId().equals(idCliente)).findAny().orElse(null);
		clientes.remove(clienteid);
		List<ClienteDTO> clientesDto = new ArrayList<ClienteDTO>();
		if(clientes != null) {
			clientes.forEach(c -> clientesDto.add(new ClienteDTO(c)));

		}
		this.clienteRepository.delete(clienteid);
		return clientesDto;
	}

}
