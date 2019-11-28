package controle;

import dao.DAO;
import dao.DAOTut;
import dao.ExcecaoObjetoNaoEncontrado;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Animal;
import modelo.Tutor;

@ManagedBean (name="tutorControle")
@ViewScoped
public class TutorControle implements Serializable {
    
    private Tutor tut;
    private DAO<Tutor> dao;
    private List<Tutor> tutores;
    private List<Animal> animais;
    private Tutor tutorSelecionado;
    private boolean popupNovo;
    private boolean popupAltera;
    
    public TutorControle(){
        tut = new Tutor();
        dao = new DAO(Tutor.class);
        tutorSelecionado = new Tutor();
        tutores = dao.listarTodos();
        popupNovo = false;
        popupAltera = false;
    }
    public void mudarAlunos(){
        System.out.println(" ................. ");
        animais = tutorSelecionado.getAnimais();
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
        tut.setNome(tut.getNome().toUpperCase());
    }
        public void alterar(){
        abrePopupAltera();
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }
    
    public List<Tutor> getTutores() {
        return tutores;
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
        // só pode inserir se não existir o login
        converter();
        boolean jaExiste = true;
        try {
            Tutor temp = new DAOTut().buscaPorNome(tut.getNome());
        } catch (ExcecaoObjetoNaoEncontrado e) {
            jaExiste = false;
        }
        if (!jaExiste) {
            dao.inserir(tut);
            tutores = dao.listarTodos();
            tut = new Tutor();
            fecharPopupNovo();
        } else {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Já existe este LOGIN", null));
        }

    }
    public void alterarTutor() {
        dao.alterar(tut);
        tutores = dao.listarTodos(); // atualiza a lista
        tut = new Tutor(); 
        fecharPopupAltera();
    }
    
    public void excluir(Tutor tut){
        dao.excluir(tut.getId());
        tutores.remove(tut);
    }
    public void setTutores(List<Tutor> tutores) {
        this.tutores = tutores;
    }

    public Tutor getTut() {
        return tut;
    }

    public void setTut(Tutor tutorSelecionado) {
        this.tut = tutorSelecionado;
    }

    public DAO<Tutor> getDao() {
        return dao;
    }

    public void setDao(DAO<Tutor> dao) {
        this.dao = dao;
    }

    public Tutor getTutorSelecionado() {
        return tutorSelecionado;
    }

    public void setTutorSelecionado(Tutor tutorSelecionado) {
        this.tutorSelecionado = tutorSelecionado;
    }
    
    
    
}