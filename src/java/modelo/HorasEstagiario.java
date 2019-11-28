/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class HorasEstagiario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 20)
    private Date data;
    @Column(length = 30)
    private Date horarioEntrada;
    @Column(length = 12)
    private Date horarioSaida;
    
    @ManyToOne
    @JoinColumn(name = "estagiario")
    private Estagiario estagiario;
    
    public HorasEstagiario(){
        data = new Date();    
        horarioEntrada = new Time(0);
        horarioSaida = new Time(0);
        estagiario = new Estagiario();
    }
    
    public HorasEstagiario(Date data, Time horarioEntrada, Time horarioSaida, Estagiario estagiario){
        this.data  = data;
        this.horarioEntrada = horarioEntrada;
        this.horarioSaida = horarioSaida;
        this.estagiario = estagiario;
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(Date horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public Date getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(Date horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public Estagiario getEstagiario() {
        return estagiario;
    }

    public void setEstagiario(Estagiario estagiario) {
        this.estagiario = estagiario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        hash = 73 * hash + Objects.hashCode(this.data);
        hash = 73 * hash + Objects.hashCode(this.horarioEntrada);
        hash = 73 * hash + Objects.hashCode(this.horarioSaida);
        hash = 73 * hash + Objects.hashCode(this.estagiario);
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
        final HorasEstagiario other = (HorasEstagiario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.horarioEntrada, other.horarioEntrada)) {
            return false;
        }
        if (!Objects.equals(this.horarioSaida, other.horarioSaida)) {
            return false;
        }
        if (!Objects.equals(this.estagiario, other.estagiario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HorasEstagiario{" + "id=" + id + ", data=" + data + ", horarioEntrada=" + horarioEntrada + ", horarioSaida=" + horarioSaida + ", estagiario=" + estagiario + '}';
    }
    
    
}
