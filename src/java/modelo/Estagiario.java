package modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Estagiario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 30)
    private String nome;
    @Column(length = 12)
    private String cpf;
    @Column(length =30)
    private String curso;
    
    @OneToMany(mappedBy = "estagiario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<HorasEstagiario> horarios;
    
    private HorasEstagiario horasTotais;
    
    public Estagiario(){
        nome = "";
        cpf = "";
        curso = "";
    }
    public Estagiario(String nome, String cpf , String curso){
        id = 0;
        this.nome = nome;
        this.cpf = cpf;
        this.curso = curso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public List<HorasEstagiario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorasEstagiario> horarios) {
        this.horarios = horarios;
    }

    public HorasEstagiario getHorasTotais() {
        return horasTotais;
    }

    public void setHorasTotais(HorasEstagiario horasTotais) {
        this.horasTotais = horasTotais;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        hash = 73 * hash + Objects.hashCode(this.nome);
        hash = 73 * hash + Objects.hashCode(this.cpf);
        hash = 73 * hash + Objects.hashCode(this.curso);
        hash = 73 * hash + Objects.hashCode(this.horarios);
        hash = 73 * hash + Objects.hashCode(this.horasTotais);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estagiario other = (Estagiario) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.curso, other.curso)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.horarios, other.horarios)) {
            return false;
        }
        if (!Objects.equals(this.horasTotais, other.horasTotais)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estagiario{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", curso=" + curso + ", horarios=" + horarios + ", horasTotais=" + horasTotais + '}';
    }
    
    
}