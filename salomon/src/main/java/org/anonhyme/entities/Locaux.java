package org.anonhyme.entities;

import org.anonhyme.entities.primarykey.LocauxPK;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Created with IntelliJ IDEA Project: salomon on 5/8/2015
 *
 * @author antoine
 */
@Entity
@IdClass(LocauxPK.class)
public class Locaux {
    private String pavillonId;
    private String localId;
    private String note;
    private Date inscription;

    @Id
    @Column(name = "pavillon_id", nullable = false, insertable = true, updatable = true, length = 2)
    public String getPavillonId() {
        return pavillonId;
    }

    public void setPavillonId(String pavillonId) {
        this.pavillonId = pavillonId;
    }

    @Id
    @Column(name = "local_id", nullable = false, insertable = true, updatable = true, length = 2147483647)
    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    @Basic
    @Column(name = "note", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

        Locaux locaux = (Locaux) o;

        if (pavillonId != null ? !pavillonId.equals(locaux.pavillonId) : locaux.pavillonId != null)
            return false;
        if (localId != null ? !localId.equals(locaux.localId) : locaux.localId != null)
            return false;
        if (note != null ? !note.equals(locaux.note) : locaux.note != null) return false;
        return !(inscription != null ? !inscription.equals(locaux.inscription) : locaux.inscription != null);

    }

    @Override
    public int hashCode() {
        int result = pavillonId != null ? pavillonId.hashCode() : 0;
        result = 31 * result + (localId != null ? localId.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (inscription != null ? inscription.hashCode() : 0);
        return result;
    }
}
