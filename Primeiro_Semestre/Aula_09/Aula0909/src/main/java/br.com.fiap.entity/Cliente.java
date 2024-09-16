import java.util.Calendar;

import javax.persistence.*; // Importa todas as anotações e classes da API JPA para mapeamento de entidades

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "TDS_TV_CLIENTE")
@SequenceGenerator(name = "cliente", sequenceName = "SQ_TDS_TB_CLIENTE", allocationSize = 1)
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
    @Column(name = "id_cliente")
    private Integer id; // Identificador único para o cliente

    @Column(name = "nm_cliente", nullable = false, length = 100)
    private String nome; // Nome do cliente

    @Temporal(TemporalType.DATE) // Grava somente a data no banco
    @Column(name = "dt_nascimento")
    private Calendar dataNascimento; // Data de nascimento do cliente

    @CreationTimestamp // Cria a data atual automaticamente no cadastro
    @Temporal(TemporalType.TIMESTAMP) // Grava a data e hora no banco
    @Column(name = "dt_cadastro", updatable = false)
    private Calendar dataCadastro; // Data de cadastro do cliente (gerada automaticamente)

    @Column(name = "vl_credito", precision = 10, scale = 3)
    private Double credito; // Valor de crédito do cliente

    @Column(name = "nr_cpf", nullable = false, length = 11)
    private String cpf; // CPF do cliente

    @Transient // Não será uma coluna na tabela
    private Integer idade; // Idade do cliente (não persistida no banco)

    @Lob
    @Column(name = "fl_foto")
    private byte[] foto; // Foto do cliente (armazenada como um array de bytes)

    @Enumerated(EnumType.STRING) // Grava o texto da constante
    @Column(name = "ds_genero", length = 20)
    private Genero genero; // Gênero do cliente (enum)

    // Construtor
    public Cliente(String nome, Calendar dataNascimento, Double credito, String cpf, Genero genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.credito = credito;
        this.cpf = cpf;
        this.genero = genero;
    }

    // Getters e Setters - métodos para acessar e modificar os campos privados da classe

    public Integer getId() {
        return id; // Retorna o ID do cliente
    }

    public void setId(Integer id) {
        this.id = id; // Define o ID do cliente
    }

    public String getNome() {
        return nome; // Retorna o nome do cliente
    }

    public void setNome(String nome) {
        this.nome = nome; // Define o nome do cliente
    }

    public Calendar getDataNascimento() {
        return dataNascimento; // Retorna a data de nascimento do cliente
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento; // Define a data de nascimento do cliente
    }

    public Calendar getDataCadastro() {
        return dataCadastro; // Retorna a data de cadastro do cliente
    }

    // O método setDataCadastro não é necessário, pois a data é gerada automaticamente com @CreationTimestamp

    public Double getCredito() {
        return credito; // Retorna o valor de crédito do cliente
    }

    public void setCredito(Double credito) {
        this.credito = credito; // Define o valor de crédito do cliente
    }

    public String getCpf() {
        return cpf; // Retorna o CPF do cliente
    }

    public void setCpf(String cpf) {
        this.cpf = cpf; // Define o CPF do cliente
    }

    public Integer getIdade() {
        return idade; // Retorna a idade do cliente (campo não persistido)
    }

    public void setIdade(Integer idade) {
        this.idade = idade; // Define a idade do cliente (campo não persistido)
    }

    public byte[] getFoto() {
        return foto; // Retorna a foto do cliente
    }

    public void setFoto(byte[] foto) {
        this.foto = foto; // Define a foto do cliente
    }

    public Genero getGenero() {
        return genero; // Retorna o gênero do cliente
    }

    public void setGenero(Genero genero) {
        this.genero = genero; // Define o gênero do cliente
    }
}
