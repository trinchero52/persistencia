package ar.com.ciu.persistencia.tp3SpringBoot.repository;

import org.springframework.data.repository.CrudRepository;

import ar.com.ciu.persistencia.tp3SpringBoot.model.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

}
