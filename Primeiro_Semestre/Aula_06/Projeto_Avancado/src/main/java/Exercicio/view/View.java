package Exercicio.view;

import Exercicio.bean.ContaCorrente;
import Exercicio.bean.ContaPoupanca;
import Exercicio.bean.TipoConta;
import Exercicio.exception.SaldoInsuficienteException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class View {
    public static void main(String[] args) {

        Calendar data = new GregorianCalendar(2024, Calendar.AUGUST, 28);

        ContaCorrente cc = new ContaCorrente(1, 123, data, 1000, TipoConta.COMUM);

        ContaPoupanca cp = new ContaPoupanca(1, 321, Calendar.getInstance(), 100, 1);

        try {
            cc.retirar(10000);
            System.out.println("Saque realizado, saldo disponível: " + cc.getSaldo());
        } catch (SaldoInsuficienteException e) {
            System.err.println(e.getMessage());
        }

        List<ContaCorrente> lista = new ArrayList<ContaCorrente>();

        lista.add(cc);
        lista.add(new ContaCorrente(123, 321, data, 500, TipoConta.ESPECIAL));
        lista.add(new ContaCorrente(123,222,Calendar.getInstance(),50,TipoConta.PREMIUM));

        for (ContaCorrente item : lista){
            System.out.println(item.getSaldo());
        }
    }
}