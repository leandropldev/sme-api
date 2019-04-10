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
@SequenceGenerator(name="SEQ_DDD", sequenceName="SEQ_DDD", allocationSize=1, schema="smeapi")
@Table(name="DDD", schema="SMEAPI")
public class Ddd {
	
	@Id
	private long id;
	private String codigo;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yy", timezone="GMT-3")
	private LocalDate criacao;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yy", timezone="GMT-3")
	private LocalDate modificacao;
	
	public Ddd() {}

	public Ddd(long id, String codigo, LocalDate criacao, LocalDate modificacao) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.criacao = criacao;
		this.modificacao = modificacao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
		return "{id=" + id + ", codigo=" + codigo + ", criacao=" + criacao + ", modificacao=" + modificacao + "}";
	}
	
}
