package dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Tutor;
import util.JPAUtil;

public class DAOTut {
    EntityManager manager;

    public Tutor buscaPorNome(String nome) throws ExcecaoObjetoNaoEncontrado{
        Tutor temp = null;
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT a FROM Administrador a WHERE a.login = :login";
        TypedQuery<Tutor> query = manager.createQuery(sql, Tutor.class);
        query.setParameter("login", nome);
        try {
            temp = query.getSingleResult();
        } catch (Exception e) {  
            throw new ExcecaoObjetoNaoEncontrado("Nenhum objeto com este login");
        } finally {
            manager.close();
        }
        return temp;
    }
}