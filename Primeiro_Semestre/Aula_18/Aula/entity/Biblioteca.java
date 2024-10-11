package br.com.fiap.jpa.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_BIBLIOTECA")
@SequenceGenerator(name="bibli", sequenceName = "SQ_TB_BIBLIOTECA", allocationSize = 1)
public class Biblioteca {

	@Id
	@Column(name="cd_biblioteca")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bibli")
	private Integer codigo;
	
	@Column(name="nm_biblioteca", nullable = false, length = 80)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_abertura")
	private Calendar dataAbertura;
	
	//Relacionamento 1:1
	@OneToOne(cascade =  { CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_endereco", nullable = false)
	private Endereco endereco;
	
	//Relacionamento M:N
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name="TB_LIVRO_BIBLIOTECA", 
		joinColumns = @JoinColumn(name="cd_biblioteca"),
		inverseJoinColumns = @JoinColumn(name="cd_livro"))
	private List<Livro> livros;
	
	public Biblioteca() {}

	public Biblioteca(String nome, Calendar dataAbertura, Endereco endereco) {
		this.nome = nome;
		this.dataAbertura = dataAbertura;
		this.endereco = endereco;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
}
