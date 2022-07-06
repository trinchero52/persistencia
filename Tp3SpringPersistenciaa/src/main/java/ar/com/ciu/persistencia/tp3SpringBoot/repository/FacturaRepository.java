package ar.com.ciu.persistencia.tp3SpringBoot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.ciu.persistencia.tp3SpringBoot.model.Factura;

@Repository
public interface FacturaRepository extends CrudRepository<Factura, Long> {

}
