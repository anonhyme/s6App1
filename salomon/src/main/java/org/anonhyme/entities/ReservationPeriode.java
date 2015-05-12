package org.anonhyme.entities;

import org.anonhyme.entities.primarykey.ReservationPeriodePK;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA Project: salomon on 5/8/2015
 *
 * @author antoine
 */
@Entity
@Table(name = "reservation_periode", schema = "public", catalog = "app1_sandbox")
@IdClass(ReservationPeriodePK.class)
public class ReservationPeriode {
    private String pavillonId;
    private String localId;
    private Time heure;
    private Date jour;

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

    @Id
    @Column(name = "heure", nullable = false, insertable = true, updatable = true)
    public Time getHeure() {
        return heure;
    }

    public void setHeure(Time heure) {
        this.heure = heure;
    }

    @Id
    @Column(name = "jour", nullable = false, insertable = true, updatable = true)
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

        ReservationPeriode that = (ReservationPeriode) o;

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
