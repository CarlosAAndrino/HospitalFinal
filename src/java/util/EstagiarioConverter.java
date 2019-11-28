package util;

import dao.DAO;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import modelo.Estagiario;


@FacesConverter(value = "estagiarioConverter")
public class EstagiarioConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String nome) {
        Estagiario temp = null;
        DAO<Estagiario> dao = new DAO(Estagiario.class);
        try {
            temp = dao.buscarPorNome(nome);
	} catch (Exception e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro","Selecione um Estagiario"));
	}
 	return temp;
    }
    
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj instanceof Estagiario){
            Estagiario c = (Estagiario)obj;
            return c.getNome();
        }
        return "";
    }    
    
}