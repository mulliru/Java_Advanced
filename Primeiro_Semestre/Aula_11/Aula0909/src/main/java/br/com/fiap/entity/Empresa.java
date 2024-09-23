package br.com.fiap.entity;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="TDS_TB_EMPRESA")
@SequenceGenerator(name = "empresa", sequenceName = "SQ_TDS_TB_EMPRESA", allocationSize = 1)
public class Empresa {

    @Id
    @Column(name = "id_empresa")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresa")
    private Integer codigo;

    @Column(name = "nm_empresa", nullable = false, length = 100)
    private String nome;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_abertura")
    private Calendar dataAbertura;

    @Column(name = "nr_cnpj", nullable = false, length = 14)
    private String cnpj;

    @Column(name = "st_ativo")
    private Boolean ativo;

    @Lob
    @Column(name = "fl_logo")
    private byte[] logo;

    @Enumerated(EnumType.STRING)
    @Column(name = "ds_porte", length = 20)
    private Porte porte;

    @Column(nullable = false, name = "vl_faturamento", precision = 10, scale = 2)
    private Double faturamento;

    @Transient
    private String token;

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public Double getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(Double faturamento) {
        this.faturamento = faturamento;
    }

    public Porte getPorte() {
        return porte;
    }

    public void setPorte(Porte porte) {
        this.porte = porte;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
