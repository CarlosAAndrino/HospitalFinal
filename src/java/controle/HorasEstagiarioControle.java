package controle;

import dao.DAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Estagiario;
import modelo.HorasEstagiario;

@ManagedBean (name="horasEstagiarioControle")
@ViewScoped
public class HorasEstagiarioControle implements Serializable {

    private List<Estagiario> estagiario;
    private Estagiario estagiarioSelecionado;
    private DAO<Estagiario> dao;
    private DAO<HorasEstagiario> daoT;
    private HorasEstagiario horasTotais;
    private List<HorasEstagiario> lista;
    private boolean popupAltera;

    public HorasEstagiarioControle() {
        estagiarioSelecionado = new Estagiario();
        dao = new DAO(Estagiario.class);
        estagiario = dao.listarTodos();
        horasTotais = new HorasEstagiario();
        daoT = new DAO(HorasEstagiario.class);
        lista = daoT.listarTodos();
        popupAltera = false;
    }
    
    public void abrePopupAltera(){
        this.popupAltera = true;
    }
    
    public void fechaPopupAltera(){
        this.popupAltera = false;
    }
    
    public void alterar(){
        abrePopupAltera();
    }
    
    public void inserir() {
        daoT.inserir(horasTotais);
        horasTotais = new HorasEstagiario();  // apenas para limpar os campos
        lista = daoT.listarTodos(); // atualiza a lista
    }

    public void alterarHorasEstagiario() {
        daoT.alterar(horasTotais);
        
        lista = daoT.listarTodos(); // atualiza a lista
        horasTotais = new HorasEstagiario(); 
        fechaPopupAltera();
    }
    
    public void excluir(HorasEstagiario horasTotais){
        daoT.excluir(horasTotais.getId());
        lista.remove(horasTotais);
    }

    public List<Estagiario> getEstagiario() {
        return estagiario;
    }

    public void setEstagiario(List<Estagiario> estagiario) {
        this.estagiario = estagiario;
    }

    public Estagiario getEstagiarioSelecionado() {
        return estagiarioSelecionado;
    }

    public void setEstagiarioSelecionado(Estagiario estagiarioSelecionado) {
        this.estagiarioSelecionado = estagiarioSelecionado;
    }

    public DAO<Estagiario> getDao() {
        return dao;
    }

    public void setDao(DAO<Estagiario> dao) {
        this.dao = dao;
    }

    public DAO<HorasEstagiario> getDaoT() {
        return daoT;
    }

    public void setDaoT(DAO<HorasEstagiario> daoT) {
        this.daoT = daoT;
    }

    public HorasEstagiario getHorasTotais() {
        return horasTotais;
    }

    public void setHorasTotais(HorasEstagiario horasTotais) {
        this.horasTotais = horasTotais;
    }

    public List<HorasEstagiario> getLista() {
        return lista;
    }

    public void setLista(List<HorasEstagiario> lista) {
        this.lista = lista;
    }

    public boolean isPopupAltera() {
        return popupAltera;
    }

    public void setPopupAltera(boolean popupAltera) {
        this.popupAltera = popupAltera;
    }
    
        
}