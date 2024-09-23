package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNaoEncontradoException;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;

public abstract class GenericDaoImpl<T,K> implements GenericDao<T,K> {

    private EntityManager em;

    private Class<T> clazz; // atributo que recebe o .class de T(entidade)

    @SuppressWarnings("all")
    public GenericDaoImpl(EntityManager em){
        this.em = em;
        // obtendo o .class da Entidade
        this.clazz = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T salvar(T entidade){
        return em.merge(entidade);
    }

    public void remover(K id) throws IdNaoEncontradoException{
        T entidade = buscar(id);
        em.remove(entidade);
    }

    public T buscar(K id) throws IdNaoEncontradoException{
        T entidade = em.find(clazz,id);
        if (entidade == null){
            throw new IdNaoEncontradoException("Entidade não encontrada");
        }
        return entidade;
    }

    public void commit() throws CommitException {
        try {
            em.getTransaction().begin();
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new CommitException();
        }
    }
}
