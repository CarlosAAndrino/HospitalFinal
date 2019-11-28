package controle;

import dao.DAO;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Estagiario;
import modelo.HorasEstagiario;

@ManagedBean (name="estagiarioControle")
@ViewScoped
public class EstagiarioControle implements Serializable {

    private Estagiario estagiario;
    private DAO<Estagiario> dao;
    private List<Estagiario> estagiarios;
    private DAO<HorasEstagiario> daoT;
    private List<HorasEstagiario> lista;
    private boolean popupAltera;
    private boolean telaHora;
    private HorasEstagiario horasTotais;
    int totalHoras = 0;

    public EstagiarioControle() {
        estagiario = new Estagiario();
        dao = new DAO(Estagiario.class);
        daoT = new DAO(HorasEstagiario.class);
        estagiarios = dao.listarTodos();
        lista = daoT.listarTodos();
        
        popupAltera = false; 
    }
   public void abreTelaHoras(){        
        this.telaHora = true;
    }
    
    public void fecharTelaHoras(){
        this.telaHora = false;
    }
    
    public void abrePopupAltera(){        
        this.popupAltera = true;
    }
    
    public void fecharPopupAltera(){
        this.popupAltera = false;
    }
    
    public void horas(){
        long horas = 0;
        totalHoras = 0;
        for(HorasEstagiario t : lista){
            if(t.getEstagiario().getId() == estagiario.getId()){
                horas = t.getHorarioSaida().getTime() - t.getHorarioEntrada().getTime();
                horas = TimeUnit.HOURS.convert(horas, TimeUnit.MILLISECONDS);
                totalHoras += horas;
            }
        }
        
        abreTelaHoras();
    }
    
    public void alterar(){
        abrePopupAltera();
    }
    
    public void inserir() {
        dao.inserir(estagiario);
        estagiario = new Estagiario();  
        estagiarios = dao.listarTodos(); 
    }

    public void alterarEstagiario() {
        dao.alterar(estagiario);
        estagiarios = dao.listarTodos();
        estagiario = new Estagiario(); 
        fecharPopupAltera();
    }
    
    public void excluir(Estagiario estagiario){
        dao.excluir(estagiario.getId());
        lista.remove(estagiario);
    }

    public int getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(int totalHoras) {
        this.totalHoras = totalHoras;
    }
    
    
    public Estagiario getEstagiario() {
        return estagiario;
    }

    public void setEstagiario(Estagiario estagiario) {
        this.estagiario = estagiario;
    }

    public DAO<Estagiario> getDao() {
        return dao;
    }

    public void setDao(DAO<Estagiario> dao) {
        this.dao = dao;
    }

    public List<Estagiario> getEstagiarios() {
        return estagiarios;
    }

    public void setEstagiarios(List<Estagiario> estagiarios) {
        this.estagiarios = estagiarios;
    }

    public DAO<HorasEstagiario> getDaoT() {
        return daoT;
    }

    public void setDaoT(DAO<HorasEstagiario> daoT) {
        this.daoT = daoT;
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

    public boolean isTelaHora() {
        return telaHora;
    }

    public void setTelaHora(boolean telaHora) {
        this.telaHora = telaHora;
    }

    public HorasEstagiario getHorasTotais() {
        return horasTotais;
    }

    public void setHorasTotais(HorasEstagiario horasTotais) {
        this.horasTotais = horasTotais;
    }
    
    
}