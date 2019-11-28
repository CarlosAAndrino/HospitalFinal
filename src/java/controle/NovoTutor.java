/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DAO;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Tutor;

/**
 *
 * @author CC46866322855
 */
@ManagedBean (name="novoTutor")
@ViewScoped
public class NovoTutor implements Serializable {
    private Tutor tut;
    private DAO<Tutor> dao;
    
    public NovoTutor(){
    tut = new Tutor();
    dao = new DAO(Tutor.class);
    }
    
    public void salvar(){
        dao.inserir(tut);
        tut = new Tutor();
    }

    public Tutor getTut() {
        return tut;
    }

    public void setTut(Tutor tut) {
        this.tut = tut;
    }

    public DAO<Tutor> getDao() {
        return dao;
    }

    public void setDao(DAO<Tutor> dao) {
        this.dao = dao;
    }
    
}
