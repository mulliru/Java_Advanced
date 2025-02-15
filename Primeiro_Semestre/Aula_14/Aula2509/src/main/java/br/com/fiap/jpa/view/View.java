package br.com.fiap.jpa.view;

import javax.persistence.EntityManger;
import br.com.fiap.jpa.entity.Investimento;
import br.com.fiap.jpa.entity.TipoInvestimento;
import br.com.fiap.jpa.factory.EntityManagerFactorySingleton;
import br.com.fiap.jpa.dao.InvestimentoDao;
import br.com.fiap.jpa.dao.InvestimentoDaoImpl;
import br.com.fiap.jpa.dao.GenericDAOImpl;



public class View {
    public static void main(String[] args) {
        //obter o entity manager
        EntityManger em = EntityManagerFactorySingleton.getInstance().createEntityManager();

        //instanciar o dao do investimento
        //gerenericcdao<invesitimento, integer> dao = new GenericDAOImpl<>(em, Investimento.class);
        InvestimentoDao dao = new InvestimentoDaoImpl(em);

        //intsnaicar um investimento (implementar um constrturor na classe)
        Investimento investimento = new Investimento("CDB TranquiloCoin", 100000001.2, TipoInvestimento.class);invest)
    }
}