/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fiap.main;

import br.com.fiap.beans.Cachorro;
import br.com.fiap.beans.Humano;
import br.com.fiap.beans.Leao;
import br.com.fiap.beans.Vaca;

/**
 *
 * @author MSWagner
 */
public class Animais {

    public static void main (String[] args) {
        Humano h = new Humano();
        h.falar();

        Vaca v = new Vaca();
        v.falar();

        Cachorro c = new Cachorro();
        c.falar();

        Leao l = new Leao();
        l.falar();
    }
}
