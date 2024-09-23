package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.entity.Investimento;

import javax.persistence.EntityManager;

public class InvestimentoDaoImpl extends GenericDaoImpl<Investimento,Integer> implements InvestimentoDao{

    public InvestimentoDaoImpl(EntityManager em){
        super(em);
    }
}
