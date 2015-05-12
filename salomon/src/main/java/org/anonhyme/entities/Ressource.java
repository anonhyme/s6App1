package org.anonhyme.entities;

import java.math.BigInteger;
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
public class Ressource {
    private BigInteger ressourceId;
    private String libelle;
    private Date inscription;

    @Id
    @Column(name = "ressource_id", nullable = false, insertable = true, updatable = true, precision = 0)
    public BigInteger getRessourceId() {
        return ressourceId;
    }

    public void setRessourceId(BigInteger ressourceId) {
        this.ressourceId = ressourceId;
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

        Ressource ressource = (Ressource) o;

        if (ressourceId != null ? !ressourceId.equals(ressource.ressourceId) : ressource.ressourceId != null)
            return false;
        if (libelle != null ? !libelle.equals(ressource.libelle) : ressource.libelle != null)
            return false;
        if (inscription != null ? !inscription.equals(ressource.inscription) : ressource.inscription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ressourceId != null ? ressourceId.hashCode() : 0;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        result = 31 * result + (inscription != null ? inscription.hashCode() : 0);
        return result;
    }
}
