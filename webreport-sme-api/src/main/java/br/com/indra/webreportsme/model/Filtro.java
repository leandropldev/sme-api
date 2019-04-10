package br.com.indra.webreportsme.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@SequenceGenerator(name="SEQ_FILTRO", sequenceName="SEQ_FILTRO", allocationSize=1, schema="smeapi")
@Table(name="FILTRO", schema="SMEAPI")
public class Filtro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="SEQ_FILTRO")
	private long id;
	private String nome;
	private String descricao;
	
	@ManyToOne
	private Canal canal;
	
	@ManyToOne
	private Menu menu;
	
	@ManyToMany
	@JoinTable(schema="smeapi")
	private List<Ddd> ddds = new ArrayList<Ddd>();
	
	@ManyToMany
	@JoinTable(schema="smeapi")
	private List<Regional> regionais = new ArrayList<Regional>();
	
	@ManyToMany
	@JoinTable(schema="smeapi")
	private List<Cnl> cnls = new ArrayList<Cnl>();
	
	@ManyToMany
	@JoinTable(schema="smeapi")
	private final List<Segmento> segmentos = new ArrayList<Segmento>();
	
	@ManyToMany
	@JoinTable(schema="smeapi")
	private final List<CicloFaturamento> ciclosFaturamento = new ArrayList<CicloFaturamento>();
	
	@ManyToMany
	@JoinTable(schema="smeapi")
	private final List<StatusLinha> statusLinha = new ArrayList<StatusLinha>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(schema="smeapi")
	private final List<Conjuncao> conjuncoes = new ArrayList<Conjuncao>();
	
	private boolean ativa = true;
	private boolean deployWas = true;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yy", timezone="GMT-3")
	private LocalDate criacao;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yy", timezone="GMT-3")
	private LocalDate modificacao;
	
	public Filtro() {}

	public Filtro(long id, String nome, String descricao, Canal canal, Menu menu, List<Ddd> ddds,
			List<Regional> regionais, List<Cnl> cnls, boolean ativa, boolean deployWas, LocalDate criacao,
			LocalDate modificacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.canal = canal;
		this.menu = menu;
		this.ddds = ddds;
		this.regionais = regionais;
		this.cnls = cnls;
		this.ativa = ativa;
		this.deployWas = deployWas;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<Ddd> getDdds() {
		return ddds;
	}

	public void setDdds(List<Ddd> ddds) {
		this.ddds = ddds;
	}

	public List<Regional> getRegionais() {
		return regionais;
	}

	public void setRegionais(List<Regional> regionais) {
		this.regionais = regionais;
	}

	public List<Cnl> getCnls() {
		return cnls;
	}

	public void setCnls(List<Cnl> cnls) {
		this.cnls = cnls;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public boolean isDeployWas() {
		return deployWas;
	}

	public void setDeployWas(boolean deployWas) {
		this.deployWas = deployWas;
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

	public List<Segmento> getSegmentos() {
		return segmentos;
	}

	public List<CicloFaturamento> getCiclosFaturamento() {
		return ciclosFaturamento;
	}

	public List<StatusLinha> getStatusLinha() {
		return statusLinha;
	}

	public List<Conjuncao> getConjuncoes() {
		return conjuncoes;
	}

	@Override
	public String toString() {
		return "{id:" + id + ", nome:" + nome + ", descricao:" + descricao + ", canal:" + canal + ", menu:"
				+ menu + ", ddds:" + ddds + ", regionais:" + regionais + ", cnls:" + cnls + ", segmentos:" + segmentos
				+ ", ciclosFaturamento:" + ciclosFaturamento + ", statusLinha:" + statusLinha + ", conjuncoes:"
				+ conjuncoes + ", ativa:" + ativa + ", deployWas:" + deployWas + ", criacao:" + criacao
				+ ", modificacao:" + modificacao + "}";
	}
}
