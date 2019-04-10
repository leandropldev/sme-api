package br.com.indra.webreportsme.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.indra.webreportsme.model.Customer;

public interface JPACustomerRepository extends JpaRepository<Customer, Integer>{

	Optional<Customer> findByName(String name);
	
}
