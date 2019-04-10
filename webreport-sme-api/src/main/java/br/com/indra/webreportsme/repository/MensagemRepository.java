package br.com.indra.webreportsme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.indra.webreportsme.model.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {

}
