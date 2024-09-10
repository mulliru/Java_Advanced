package Exercicio.bean;

import Exercicio.exception.SaldoInsuficienteException;

import java.util.Calendar;

public class ContaPoupanca extends Conta implements ContaInvestimento {

    private float taxa;

    public static final float RENDIMENTO = 0.05f;

    public ContaPoupanca(int numero, int agencia, Calendar dataAbertura, double saldo, float taxa) {
        super(numero, agencia, dataAbertura, saldo);
        this.taxa = taxa;
    }

    @Override
    public double calculaRetornoInvestimento() {
        return saldo * RENDIMENTO;
    }

    @Override
    public void retirar(double valor) throws SaldoInsuficienteException {
        if (saldo < valor + taxa){
            throw new SaldoInsuficienteException(saldo);
        }
        saldo -= valor + taxa;
    }

    public float getTaxa() {
        return taxa;
    }

    public void setTaxa(float taxa) {
        this.taxa = taxa;
    }
}
