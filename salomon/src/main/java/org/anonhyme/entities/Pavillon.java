package org.anonhyme.entities;

import java.sql.Date;

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
public class Pavillon {
    private String pavillonId;
    private String libelle;
    private Date inscription;

    @Id
    @Column(name = "pavillon_id", nullable = false, insertable = true, updatable = true, length = 2)
    public String getPavillonId() {
        return pavillonId;
    }

    public void setPavillonId(String pavillonId) {
        this.pavillonId = pavillonId;
    }

    @Basic
    @Column(name = "libelle", nullable = false, insertable = true, updatable = true, length = 2147483647)
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
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

        Pavillon pavillon = (Pavillon) o;

        if (pavillonId != null ? !pavillonId.equals(pavillon.pavillonId) : pavillon.pavillonId != null)
            return false;
        if (libelle != null ? !libelle.equals(pavillon.libelle) : pavillon.libelle != null)
            return false;
        if (inscription != null ? !inscription.equals(pavillon.inscription) : pavillon.inscription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pavillonId != null ? pavillonId.hashCode() : 0;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        result = 31 * result + (inscription != null ? inscription.hashCode() : 0);
        return result;
    }
}
