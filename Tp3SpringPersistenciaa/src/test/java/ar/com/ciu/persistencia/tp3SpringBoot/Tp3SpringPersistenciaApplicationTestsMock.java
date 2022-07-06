package ar.com.ciu.persistencia.tp3SpringBoot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.ciu.persistencia.tp3SpringBoot.dto.ClienteDTO;
import ar.com.ciu.persistencia.tp3SpringBoot.dto.CuentaDTO;
import ar.com.ciu.persistencia.tp3SpringBoot.dto.FacturaDTO;
import ar.com.ciu.persistencia.tp3SpringBoot.model.General;
import ar.com.ciu.persistencia.tp3SpringBoot.model.Precio;
import ar.com.ciu.persistencia.tp3SpringBoot.service.ClientServiceImpl;
import ar.com.ciu.persistencia.tp3SpringBoot.service.CuentaServiceImple;
import ar.com.ciu.persistencia.tp3SpringBoot.service.FacturaServiceImple;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class Tp3SpringPersistenciaApplicationTestsMock {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper = new ObjectMapper();;

	@MockBean
	private FacturaServiceImple facturaServiceImple;

	@Autowired
	private ClientServiceImpl clienteServiceImple;

	@Autowired
	private CuentaServiceImple cuentaServiceImple;

	@Test
	public void createFactura() throws Exception {
		Precio precio = new Precio(new BigDecimal(5), new Date());
		General general = new General("123", "Producto General", 120);

		CuentaDTO cuentaDto = new CuentaDTO("30");
		
		

		cuentaServiceImple.create(cuentaDto);
		
		System.out.println(cuentaDto.toString());

		ClienteDTO clienteDto = new ClienteDTO("123", "Fica", "Enzo");

		clienteDto.setCuenta(cuentaDto.getCuenta());
		
		clienteServiceImple.create(clienteDto);

		//System.out.println("cliDto" + clienteDto.getCliente().toString());

		System.out.println("cli" + clienteDto);

		general.setPrecio(precio);

		FacturaDTO facturaDto = new FacturaDTO(new Date(), 12);

		facturaDto.setCliente(clienteDto.getCliente());

		System.out.println(facturaDto.toString());

		facturaServiceImple.create(facturaDto, general, 10);

		// Mockito.when(facturaServiceImple.create(facturaDto, general,
		// 10)).thenReturn(facturaDto);

//		Mockito.when(cuentaServiceImple.create(cuentaDto)).thenReturn(cuentaDto);
//		
//		Mockito.when(clienteServiceImple.create(clienteDto)).thenReturn(clienteDto);
//		
//		mockMvc.perform(post("/cuenta")
//	            .contentType("application/json")
//	            .content(objectMapper.writeValueAsString(cuentaDto)))
//	            .andExpect(status().isCreated());
//		
//		mockMvc.perform(post("/cliente")
//	            .contentType("application/json")
//	            .content(objectMapper.writeValueAsString(clienteDto)))
//	            .andExpect(status().isCreated());

		mockMvc.perform(
				post("/factura").contentType("application/json").content(objectMapper.writeValueAsString(facturaDto)))
				.andExpect(status().isCreated());

		assertThat(facturaDto.getNumero()).isEqualTo(12);
	}
}
