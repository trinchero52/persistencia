package ar.com.ciu.persistencia.market.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ciu.persistencia.market.dto.ClienteDTO;
import ar.com.ciu.persistencia.market.model.Cliente;
import ar.com.ciu.persistencia.market.repository.ClienteRepository;

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
		List<Cliente> clientes =  (List<Cliente>) this.clienteRepository.findAll();
		List<ClienteDTO> clientesDto = new ArrayList<ClienteDTO>();
		if(clientes != null) {
			clientes.forEach(c -> clientesDto.add(new ClienteDTO(c)));

		}
		return clientesDto;
	}

	@Override
	public ClienteDTO update(ClienteDTO clienteDTO, Long id) {
		Cliente cliente = this.clienteRepository.findById(id).orElse(null);
		cliente.setApellido(clienteDTO.getApellido());
		cliente.setCodigo(clienteDTO.getCodigo());
		cliente.setNombre(clienteDTO.getNombre());
		this.clienteRepository.save(cliente);
		return new ClienteDTO(cliente);
	}

	@Override
	public List<ClienteDTO> delete(Long idCliente) {
		List<Cliente> clientes = (List<Cliente>) this.clienteRepository.findAll();
		Cliente elCliente = clientes.stream().filter(c -> c.getId().equals(idCliente)).findAny().orElse(null);
		clientes.removeIf(c -> c.getId().equals(idCliente));
		List<ClienteDTO> clientesDto = new ArrayList<ClienteDTO>();
		if(clientes != null) {
			clientes.forEach(c -> clientesDto.add(new ClienteDTO(c)));

		}
		this.clienteRepository.delete(elCliente);
		return clientesDto;
	}

}
