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

import br.com.indra.webreportsme.model.Mensagem;
import br.com.indra.webreportsme.repository.MensagemRepository;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {
	private static final Logger logger = LoggerFactory.getLogger(MensagemController.class);
	
	@Autowired
	MensagemRepository mensagemRepository;
	
	@PostMapping("/adicionaMensagem")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Mensagem adicionaMensagem(@Valid @RequestBody Mensagem mensagem) {
		logger.info("Adicionando nova mensagem ... ");
		
		mensagem.setCriacao(LocalDate.now(ZoneId.systemDefault()));
		mensagem.setModificacao(LocalDate.now(ZoneId.systemDefault()));
		
		return mensagemRepository.save(mensagem);
	}
	
	@GetMapping("/listarMensagens")
	public ResponseEntity<List<Mensagem>> listarMensagens(){
		logger.info("Listando todas as Mensagems ... ");
		
		return ResponseEntity.ok(mensagemRepository.findAll());
	}
	
	@PutMapping("/editarMensagem")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public ResponseEntity<Mensagem> editarMensagem(@Valid @RequestBody Mensagem mensagem){
		logger.info("Editando a mensagem de id ["+ mensagem.getId() +"]");
		
		Optional<Mensagem> mensagemById = mensagemRepository.findById(mensagem.getId());
		if(mensagemById.isPresent()) {
			mensagem.setModificacao(LocalDate.now(ZoneId.systemDefault()));
			mensagem.setCriacao(mensagemById.get().getCriacao());
			
			return ResponseEntity.ok(mensagemRepository.save(mensagem));
		} else {
			logger.info("Não foi localizado nenhuma mensagem com o id [" + mensagem.getId() + "]");
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/deletaMensagemByID/{id}")
	public void deletaMensagemByID(@PathVariable long id) {
		logger.info("Excluindo a mensagem de id[" + id + "]");
		mensagemRepository.deleteById(id);
	}
	
	@GetMapping("/downloadMensagem")
	public void downloadMensagem() {
		
	}

}
