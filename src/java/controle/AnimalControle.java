package controle;

import dao.DAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Animal;

@ManagedBean (name="animalControle")
@ViewScoped
public class AnimalControle implements Serializable {
    
    private Animal ani;
    private DAO<Animal> dao;
    private List<Animal> animais;
    private boolean popupNovo;
    private boolean popupAltera;
    
    public AnimalControle(){
        ani = new Animal();
        dao = new DAO(Animal.class);
        animais = dao.listarTodos();
        popupNovo = false;
        popupAltera = false;
    }
    
    public void abrePopupNovo() {
        this.popupNovo = true;
    }

    public void fecharPopupNovo() {
        this.popupNovo = false;
    }
    
    public void abrePopupAltera(){        
        this.popupAltera = true;
    }
    
    public void fecharPopupAltera(){
        this.popupAltera = false;
    }
    
    public void converter() {
        ani.setNome(ani.getNome().toUpperCase());
    }
        public void alterar(){
        abrePopupAltera();
    }
    
    public List<Animal> getAnimais() {
        return animais;
    }

    public boolean isPopupNovo() {
        return popupNovo;
    }

    public void setPopupNovo(boolean popupNovo) {
        this.popupNovo = popupNovo;
    }

    public boolean isPopupAltera() {
        return popupAltera;
    }

    public void setPopupAltera(boolean popupAltera) {
        this.popupAltera = popupAltera;
    }
    
    public void inserir() {
            dao.inserir(ani);
            animais = dao.listarTodos();
            ani = new Animal();
            fecharPopupNovo();
        }

    
    public void alterarAnimal() {
        dao.alterar(ani);
        animais = dao.listarTodos();
        ani = new Animal(); 
        fecharPopupAltera();
    }
    
    public void excluir(Animal ani){
        dao.excluir(ani.getId());
        animais.remove(ani);
    }
    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public Animal getAni() {
        return ani;
    }

    public void setAni(Animal animalSelecionado) {
        this.ani = animalSelecionado;
    }

    public DAO<Animal> getDao() {
        return dao;
    }

    public void setDao(DAO<Animal> dao) {
        this.dao = dao;
    }
    
    
    
}