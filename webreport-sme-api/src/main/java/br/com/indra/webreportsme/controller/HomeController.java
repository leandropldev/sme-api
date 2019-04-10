package br.com.indra.webreportsme.controller;

import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.indra.webreportsme.model.Customer;
import br.com.indra.webreportsme.repository.JPACustomerRepository;

@RestController
@RequestMapping("/customer")
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
    DataSource dataSource;
    
    @Autowired
    JPACustomerRepository jpaCustomerRepository;
    
	@RequestMapping("/listar")
	public ResponseEntity<List<Customer>> home() {
		logger.info("Entrando na HomePage [LISTA ALL]");
        return ResponseEntity.ok(jpaCustomerRepository.findAll());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Customer adicionar(@Valid @RequestBody Customer customer){
		
		Customer savecustomer = jpaCustomerRepository.save(customer);
		logger.info("Adicionando Customer: " + savecustomer.toString());
		
		return savecustomer;
	}
	
	@GetMapping("/listaNome/{name}")
	public ResponseEntity<Customer> findByName(@PathVariable String name) {
		
		Optional<Customer> customer = jpaCustomerRepository.findByName(name);
		if(customer.isPresent())
			return ResponseEntity.ok(customer.get());

		return ResponseEntity.notFound().build();
		
	}
}
