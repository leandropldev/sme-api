package br.com.indra.webreportsme.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@SequenceGenerator(name="SEQ_PONTO", sequenceName="SEQ_PONTO", allocationSize=1, schema="smeapi")
@Table(name="PONTO", schema="SMEAPI")
public class Ponto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="SEQ_PONTO")
	private long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yy", timezone="GMT-3")
	private LocalDate criacao;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yy", timezone="GMT-3")
	private LocalDate modificacao;
	
	private String descricao;
	private String nome;
	
	public Ponto() {}
	
	public Ponto(LocalDate criacao, LocalDate modificacao, String descricao, String nome) {
		super();
		this.criacao = criacao;
		this.modificacao = modificacao;
		this.descricao = descricao;
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "{id=" + id + ", criacao=" + criacao + ", modificacao=" + modificacao + ", descricao="
				+ descricao + ", nome=" + nome + "}";
	}
	
}
