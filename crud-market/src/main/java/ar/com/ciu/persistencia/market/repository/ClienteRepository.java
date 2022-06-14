package ar.com.ciu.persistencia.market.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.ciu.persistencia.market.model.Cliente;


@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {		// Le indico el tipo de dato y la primary key

}
