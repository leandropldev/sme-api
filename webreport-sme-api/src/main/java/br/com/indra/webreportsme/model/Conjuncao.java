package br.com.indra.webreportsme.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@SequenceGenerator(name="SEQ_CONJUNCAO", sequenceName="SEQ_CONJUNCAO", allocationSize=1, schema="smeapi")
@Table(name="CONJUNCAO", schema="SMEAPI")
public class Conjuncao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="SEQ_CONJUNCAO")
	private long id;
	//private Filtro filtro;
	
	@ManyToOne
	private Mensagem mensagem;
	
	@ManyToOne
	private Ponto ponto;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yy HH:mm", timezone="GMT-3")
	@DateTimeFormat(pattern = "dd/MM/yy HH:mm", iso = ISO.DATE_TIME)
	private LocalDateTime vigenciaDe;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yy HH:mm", timezone="GMT-3")
	@DateTimeFormat(pattern = "dd/MM/yy HH:mm", iso = ISO.DATE_TIME)
	private LocalDateTime vigenciaAte;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yy", timezone="GMT-3")
	private LocalDate criacao;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yy", timezone="GMT-3")
	private LocalDate modificacao;
	
	public Conjuncao() {}

	public Conjuncao(long id, Mensagem mensagem, Ponto ponto, LocalDateTime vigenciaDe, LocalDateTime vigenciaAte, LocalDate criacao, LocalDate modificacao) {
		super();
		this.id = id;
		this.mensagem = mensagem;
		this.ponto = ponto;
		this.criacao = criacao;
		this.modificacao = modificacao;
		this.vigenciaDe = vigenciaDe;
		this.vigenciaAte = vigenciaAte;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}

	public Ponto getPonto() {
		return ponto;
	}

	public void setPonto(Ponto ponto) {
		this.ponto = ponto;
	}
	
	
	public LocalDateTime getVigenciaDe() {
		return vigenciaDe;
	}

	public void setVigenciaDe(LocalDateTime vigenciaDe) {
		this.vigenciaDe = vigenciaDe;
	}

	public LocalDateTime getVigenciaAte() {
		return vigenciaAte;
	}

	public void setVigenciaAte(LocalDateTime vigenciaAte) {
		this.vigenciaAte = vigenciaAte;
	}

	public LocalDate getCriacao() {
		return criacao;
	}

	public void setCriacao(LocalDate criacao) {
		this.criacao = criacao;
	}

	public LocalDate getModificacao() {
		return modificacao;
	}

	public void setModificacao(LocalDate modificacao) {
		this.modificacao = modificacao;
	}

	@Override
	public String toString() {
		return "{id=" + id + ", mensagem=" + mensagem + ", ponto=" + ponto
				+ ", criacao=" + criacao + ", modificacao=" + modificacao + "}";
	}
}
