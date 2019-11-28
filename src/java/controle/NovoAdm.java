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
import modelo.Administrador;

/**
 *
 * @author CC46866322855
 */
@ManagedBean (name="novoAdm")
@ViewScoped
public class NovoAdm implements Serializable {
    private Administrador adm;
    private DAO<Administrador> dao;
    
    public NovoAdm(){
    adm = new Administrador();
    dao = new DAO(Administrador.class);
    }
    
    public void salvar(){
        dao.inserir(adm);
        adm = new Administrador();
    }

    public Administrador getAdm() {
        return adm;
    }

    public void setAdm(Administrador adm) {
        this.adm = adm;
    }

    public DAO<Administrador> getDao() {
        return dao;
    }

    public void setDao(DAO<Administrador> dao) {
        this.dao = dao;
    }
    
}
