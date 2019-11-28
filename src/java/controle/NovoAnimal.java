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
import modelo.Animal;

/**
 *
 * @author CC46866322855
 */
@ManagedBean (name="novoAnimal")
@ViewScoped
public class NovoAnimal implements Serializable {
    private Animal ani;
    private DAO<Animal> dao;
    
    public NovoAnimal(){
    ani = new Animal();
    dao = new DAO(Animal.class);
    }
    
    public void salvar(){
        dao.inserir(ani);
        ani = new Animal();
    }

    public Animal getAni() {
        return ani;
    }

    public void setAni(Animal ani) {
        this.ani = ani;
    }

    public DAO<Animal> getDao() {
        return dao;
    }

    public void setDao(DAO<Animal> dao) {
        this.dao = dao;
    }
    
}
