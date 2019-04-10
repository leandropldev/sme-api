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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.indra.webreportsme.model.Filtro;
import br.com.indra.webreportsme.repository.FiltroRepository;

@RestController
@RequestMapping("/filtro")
public class FiltroController {
	private static final Logger logger = LoggerFactory.getLogger(FiltroController.class);
	
	@Autowired
	FiltroRepository filtroRepository;
	
	@PostMapping("/adicionaFiltro")
	@ResponseStatus(HttpStatus.CREATED)
	public Filtro adicionaFiltro(@Valid @RequestBody Filtro filtro) {
		
		filtro.setCriacao(LocalDate.now(ZoneId.systemDefault()));
		filtro.setModificacao(LocalDate.now(ZoneId.systemDefault()));
		
		for (int i = 0; i < filtro.getConjuncoes().size(); i++) {
			filtro.getConjuncoes().get(i).setCriacao(LocalDate.now(ZoneId.systemDefault()));
			filtro.getConjuncoes().get(i).setModificacao(LocalDate.now(ZoneId.systemDefault()));
		}
		
		logger.info("adicionando Filtro: " + filtro.toString());
		return filtroRepository.save(filtro);
	}
	
	@GetMapping("/listarFiltros")
	public ResponseEntity<List<Filtro>> listarFiltros() {
		logger.info("Retornando a lista de Filtros...");
		
		return ResponseEntity.ok(filtroRepository.findAll());
	}
	
	@PutMapping("/editarFiltro")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public ResponseEntity<Filtro> editarFiltro(@Valid @RequestBody Filtro filtro){
		logger.info("Editando o filtro com id: " + filtro.getId());
		Optional<Filtro> filtroById = filtroRepository.findById(filtro.getId());
		
		if(filtroById.isPresent()) {
			filtro.setModificacao(LocalDate.now(ZoneId.systemDefault()));
			
			//precisamos saber se a mensagem ou o ponto foi alterado para atualizar a data de modificacao da conjuncao!!
			for (int i = 0; i < filtro.getConjuncoes().size() ; i++) {
				if(filtro.getConjuncoes().get(i).getMensagem().getId() != filtroById.get().getConjuncoes().get(i).getMensagem().getId()
						|| filtro.getConjuncoes().get(i).getPonto().getId() !=  filtroById.get().getConjuncoes().get(i).getPonto().getId()) {
					
					filtro.getConjuncoes().get(i).setModificacao(LocalDate.now(ZoneId.systemDefault()));
					filtro.getConjuncoes().get(i).setCriacao(filtroById.get().getConjuncoes().get(i).getCriacao());
				} else {
					filtro.getConjuncoes().get(i).setModificacao(filtroById.get().getConjuncoes().get(i).getModificacao());
					filtro.getConjuncoes().get(i).setCriacao(filtroById.get().getConjuncoes().get(i).getCriacao());
				}
			}
			
			logger.info("Filtro com o id [" + filtro.getId() + "] editado com sucesso!");
			return ResponseEntity.ok(filtroRepository.save(filtro));
		} else {
			logger.info("Filtro com o id [" + filtro.getId() + "] não localizado na base!");
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/deletaFiltroByID/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void deletaFiltroByID(@PathVariable long id) {
		logger.info("Deletando filtro com id[" +id+ "]");
		filtroRepository.deleteById(id);
	}
}
