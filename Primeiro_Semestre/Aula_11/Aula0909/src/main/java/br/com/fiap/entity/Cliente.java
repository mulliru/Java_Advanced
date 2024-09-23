package br.com.fiap.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="TDS_TB_CLIENTE")
// name = nome igual ao generator, sequenceName = nome no banco, allocationSize = incremento
@SequenceGenerator(name="cliente", sequenceName = "SQ_TDS_TB_CLIENTE", allocationSize = 1)
public class Cliente {

    @Id
    @Column(name="id_cliente")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
    private Integer id;

    @Column(name="nm_cliente", nullable = false, length = 100)
    private String nome;

    @Temporal(TemporalType.DATE) // grava somente a data no banco
    @Column(name = "dt_nascimento")
    private Calendar dataNascimento;

    @CreationTimestamp // cria a data atual do cadastro
    @Temporal(TemporalType.TIMESTAMP) // grava a data e hora no banco
    @Column(name = "dt_cadastro", updatable = false)
    private Calendar dataCadastro;

    @Column(name = "vl_credito", precision = 10, scale = 3)
    private Double credito;

    @Column(name = "nr_cpf",nullable = false,length = 11)
    private String cpf;

    @Transient // não será uma coluna
    private Integer idade;

    @Lob
    @Column(name = "fl_foto")
    private byte[] foto;

    @Enumerated(EnumType.STRING) // grava o texto da constante
    @Column(name = "ds_genero",length = 20)
    private Genero genero;

    public Cliente(){}

    public Cliente(String nome, Calendar dataNascimento, Double credito, String cpf, Genero genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.credito = credito;
        this.cpf = cpf;
        this.genero = genero;
    }

    @PostPersist // executa o método após o persist
    private void executar(){
        System.out.println("Executando o método...");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Double getCredito() {
        return credito;
    }

    public void setCredito(Double credito) {
        this.credito = credito;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
