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
@SequenceGenerator(name="SEQ_CNL", sequenceName="SEQ_CNL", allocationSize=1, schema="smeapi")
@Table(name="CNL", schema="SMEAPI")
public class Cnl {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="SEQ_CNL")
	private long id;
	private String nome;
	private String uf;
	private String municipio;
	private String codigoCnl;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yy", timezone="GMT-3")
	private LocalDate criacao;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yy", timezone="GMT-3")
	private LocalDate modificacao;
	
	public Cnl() {}

	public Cnl(long id, String nome, String uf, String municipio, String codigoCnl, LocalDate criacao,
			LocalDate modificacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.uf = uf;
		this.municipio = municipio;
		this.codigoCnl = codigoCnl;
		this.criacao = criacao;
		this.modificacao = modificacao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getCodigoCnl() {
		return codigoCnl;
	}

	public void setCodigoCnl(String codigoCnl) {
		this.codigoCnl = codigoCnl;
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
		return "{id=" + id + ", nome=" + nome + ", uf=" + uf + ", municipio=" + municipio + ", codigoCnl="
				+ codigoCnl + ", criacao=" + criacao + ", modificacao=" + modificacao + "}";
	}
	
	
}
