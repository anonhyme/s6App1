package org.anonhyme.entities;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA Project: salomon on 5/8/2015
 *
 * @author antoine
 */
@Entity
public class Periode {
    private Time heure;
    private Date inscription;

    @Id
    @Column(name = "heure", nullable = false, insertable = true, updatable = true)
    public Time getHeure() {
        return heure;
    }

    public void setHeure(Time heure) {
        this.heure = heure;
    }

    @Basic
    @Column(name = "inscription", nullable = false, insertable = true, updatable = true)
    public Date getInscription() {
        return inscription;
    }

    public void setInscription(Date inscription) {
        this.inscription = inscription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Periode periode = (Periode) o;

        if (heure != null ? !heure.equals(periode.heure) : periode.heure != null) return false;
        if (inscription != null ? !inscription.equals(periode.inscription) : periode.inscription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = heure != null ? heure.hashCode() : 0;
        result = 31 * result + (inscription != null ? inscription.hashCode() : 0);
        return result;
    }
}
