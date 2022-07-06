package ar.com.ciu.persistencia.tp3SpringBoot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.ciu.persistencia.tp3SpringBoot.model.Detalle;

@Repository
public interface DetalleRepository extends CrudRepository<Detalle, Long> {

}
