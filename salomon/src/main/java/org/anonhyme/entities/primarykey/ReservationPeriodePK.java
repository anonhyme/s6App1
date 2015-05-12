package org.anonhyme.entities.primarykey;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA Project: salomon on 5/8/2015
 *
 * @author antoine
 */
public class ReservationPeriodePK implements Serializable {
    private String pavillonId;

    @Column(name = "pavillon_id", nullable = false, insertable = true, updatable = true, length = 2)
    @Id
    public String getPavillonId() {
        return pavillonId;
    }

    public void setPavillonId(String pavillonId) {
        this.pavillonId = pavillonId;
    }

    private String localId;

    @Column(name = "local_id", nullable = false, insertable = true, updatable = true, length = 2147483647)
    @Id
    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    private Time heure;

    @Column(name = "heure", nullable = false, insertable = true, updatable = true)
    @Id
    public Time getHeure() {
        return heure;
    }

    public void setHeure(Time heure) {
        this.heure = heure;
    }

    private Date jour;

    @Column(name = "jour", nullable = false, insertable = true, updatable = true)
    @Id
    public Date getJour() {
        return jour;
    }

    public void setJour(Date jour) {
        this.jour = jour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationPeriodePK that = (ReservationPeriodePK) o;

        if (pavillonId != null ? !pavillonId.equals(that.pavillonId) : that.pavillonId != null)
            return false;
        if (localId != null ? !localId.equals(that.localId) : that.localId != null) return false;
        if (heure != null ? !heure.equals(that.heure) : that.heure != null) return false;
        if (jour != null ? !jour.equals(that.jour) : that.jour != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pavillonId != null ? pavillonId.hashCode() : 0;
        result = 31 * result + (localId != null ? localId.hashCode() : 0);
        result = 31 * result + (heure != null ? heure.hashCode() : 0);
        result = 31 * result + (jour != null ? jour.hashCode() : 0);
        return result;
    }
}
