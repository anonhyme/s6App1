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
public class Evenement {
    private BigInteger evenementId;
    private String libelle;
    private Date inscription;

    @Id
    @Column(name = "evenement_id", nullable = false, insertable = true, updatable = true, precision = 0)
    public BigInteger getEvenementId() {
        return evenementId;
    }

    public void setEvenementId(BigInteger evenementId) {
        this.evenementId = evenementId;
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

        Evenement evenement = (Evenement) o;

        if (evenementId != null ? !evenementId.equals(evenement.evenementId) : evenement.evenementId != null)
            return false;
        if (libelle != null ? !libelle.equals(evenement.libelle) : evenement.libelle != null)
            return false;
        return !(inscription != null ? !inscription.equals(evenement.inscription) : evenement.inscription != null);

    }

    @Override
    public int hashCode() {
        int result = evenementId != null ? evenementId.hashCode() : 0;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        result = 31 * result + (inscription != null ? inscription.hashCode() : 0);
        return result;
    }
}
