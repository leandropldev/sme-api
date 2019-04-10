package br.com.indra.webreportsme.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.indra.webreportsme.model.Ponto;
import br.com.indra.webreportsme.repository.PontoRepository;

@RestController
@RequestMapping("/ponto")
public class PontoController {
	private static final Logger logger = LoggerFactory.getLogger(PontoController.class);
	
	@Autowired
	PontoRepository pontoRepository;
	
	@PostMapping("/adicionarPonto")
	@ResponseStatus(HttpStatus.CREATED)
	public Ponto adicionarPonto(@Valid @RequestBody Ponto ponto) {
		
		Ponto savePonto = pontoRepository.save(ponto);
		logger.info("Ponto adicionado: " + savePonto.toString());
		
		return savePonto;
	}
	
	@RequestMapping("/listarPontos")
	public ResponseEntity<List<Ponto>> listarPontos(){
		
		logger.info("Retornando lista de Pontos");
		return ResponseEntity.ok(pontoRepository.findAll());
	}
	
	@PutMapping("/editarPonto")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<Ponto> editarPonto(@Valid @RequestBody Ponto ponto) {
		logger.info("Editando o ponto com id [" + ponto.getId() +"]");
		Optional<Ponto> optionalPonto = pontoRepository.findById(ponto.getId());
		
		if(optionalPonto.isPresent()) {
			logger.info("Ponto com id [" + ponto.getId() + "] editado com sucesso");

			ponto.setModificacao(LocalDate.now(ZoneId.systemDefault()));
			return ResponseEntity.ok(pontoRepository.save(ponto));				
		} else {
			logger.info("Não foi localizado nenhum ponto com o id [" + ponto.getId() + "] para ser editado");
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/removerPonto/{id}")
	public void removerPonto(@PathVariable long id){
		logger.info("Excluindo a Ponto de id[" + id + "]");
		pontoRepository.deleteById(id);
	}
}
