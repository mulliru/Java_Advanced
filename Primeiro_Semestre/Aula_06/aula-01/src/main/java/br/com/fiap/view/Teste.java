package br.com.fiap.view;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.anotation.Coluna;
import br.com.fiap.model.Pessoa;

public class Teste {

    public static void main(String[] args) {
        
        // Instanciar uma pessoa
        Pessoa pessoa = new Pessoa();
        
        // Recuperar o nome da classe através da API da Reflection
        String nomeClasse = pessoa.getClass().getName();
        System.out.println(nomeClasse);
        
        // Recuperar os métodos da classe através da API da reflection
        Method[] metodos = pessoa.getClass().getDeclaredMethods();
        
        // Exibir o nome dos métodos
        for (Method m : metodos) {
            System.out.println(m.getName());
        }
        
        // Recuperar os atributos de classe
        Field[] atributos = pessoa.getClass().getDeclaredFields();
        
        // Exibir o nome e o tipo dos atributos
        for (Field f : atributos) {
            System.out.println(f.getName() + " " + f.getType());
            
            // Recuperar a anotação @Coluna
            Coluna anotacao = f.getAnnotation(Coluna.class);
            
            // Exibir os parâmetros da anotação, se a anotação estiver presente
            if (anotacao != null) {
                System.out.println(anotacao.nome() + " " + anotacao.tamanho() + " " + anotacao.obrigatorio());
            }
        }
    }
}
