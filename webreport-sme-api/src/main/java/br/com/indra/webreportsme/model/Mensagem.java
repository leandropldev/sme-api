package br.com.indra.webreportsme.model;

import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.indra.webreportsme.model.enums.TipoMensagem;

@Entity
@SequenceGenerator(name="SEQ_MENSAGEM", sequenceName="SEQ_MENSAGEM", allocationSize=1, schema="smeapi")
@Table(name="MENSAGEM", schema="SMEAPI")
public class Mensagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="SEQ_MENSAGEM")
	private long id;
	private String nome;
	private byte[] arquivo;
	private boolean ativa = true;
	@Enumerated(EnumType.STRING)
	private TipoMensagem tipoMensagem;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yy", timezone="GMT-3")
	private LocalDate criacao;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yy", timezone="GMT-3")
	private LocalDate modificacao;
	
	public Mensagem() {}

	public Mensagem(long id, String nome, byte[] arquivo, boolean ativa, TipoMensagem tipoMensagem, LocalDate criacao,
			LocalDate modificacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.arquivo = arquivo;
		this.ativa = ativa;
		this.tipoMensagem = tipoMensagem;
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

	public byte[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public TipoMensagem getTipoMensagem() {
		return tipoMensagem;
	}

	public void setTipoMensagem(TipoMensagem tipoMensagem) {
		this.tipoMensagem = tipoMensagem;
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
		return "{id=" + id + ", nome=" + nome + ", arquivo=" + Arrays.toString(arquivo) + ", ativa=" + ativa
				+ ", tipoMensagem=" + tipoMensagem + ", criacao=" + criacao + ", modificacao=" + modificacao + "}";
	}

}
