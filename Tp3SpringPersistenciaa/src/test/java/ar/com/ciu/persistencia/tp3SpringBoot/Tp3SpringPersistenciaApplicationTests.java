package ar.com.ciu.persistencia.tp3SpringBoot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.com.ciu.persistencia.tp3SpringBoot.model.General;
import ar.com.ciu.persistencia.tp3SpringBoot.model.Precio;
import ar.com.ciu.persistencia.tp3SpringBoot.model.Proveedor;
import ar.com.ciu.persistencia.tp3SpringBoot.service.ProductoServiceImple;
import ar.com.ciu.persistencia.tp3SpringBoot.service.ProveedorServiceImple;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class Tp3SpringPersistenciaApplicationTests {

	@Autowired
	private ProveedorServiceImple proveedorService;
	
	@Autowired
	private ProductoServiceImple productoService;
	
	Proveedor proveedor = new Proveedor("Proveedor 1");

	@Test
	public void contextLoads() throws Exception {
		assertThat(proveedorService).isNotNull();
		assertThat(productoService).isNotNull();
	}

	@Test
	public void createProveedor() {
		proveedor = proveedorService.create(proveedor);
		assertNotNull(proveedor.getId());
	}
	
	@Test
	public void createGeneral() {
		Precio precio = new Precio(new BigDecimal(5), new Date());
		General general = new General("123", "Producto General", 120);
		
		general.setPrecio(precio);
		general.getProveedores().add(proveedor);
		productoService.create(general);
		assertEquals(general.getPeso(), 120);
	}
}
