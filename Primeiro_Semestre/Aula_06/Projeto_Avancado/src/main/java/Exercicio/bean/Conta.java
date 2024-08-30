package Exercicio.bean;

import Exercicio.exception.SaldoInsuficienteException;

import java.util.Calendar;

public abstract class Conta {

    private int numero;
    private int agencia;
    private Calendar dataAbertura;
    protected double saldo;

    public Conta(int numero, int agencia, Calendar dataAbertura, double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.dataAbertura = dataAbertura;
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public abstract void retirar(double valor) throws SaldoInsuficienteException;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public Calendar getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Calendar dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
