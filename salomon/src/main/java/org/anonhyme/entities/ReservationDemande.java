package org.anonhyme.entities;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA Project: salomon on 5/8/2015
 *
 * @author antoine
 */
@Entity
@Table(name = "reservation_demande", schema = "public", catalog = "app1_sandbox")
public class ReservationDemande {
    private int reservationDemandeId;
    private Date jour;
    private int duree;
    private String description;
    private Date inscription;

    @Id
    @Column(name = "reservation_demande_id", nullable = false, insertable = true, updatable = true)
    public int getReservationDemandeId() {
        return reservationDemandeId;
    }

    public void setReservationDemandeId(int reservationDemandeId) {
        this.reservationDemandeId = reservationDemandeId;
    }

    @Basic
    @Column(name = "jour", nullable = false, insertable = true, updatable = true)
    public Date getJour() {
        return jour;
    }

    public void setJour(Date jour) {
        this.jour = jour;
    }

    @Basic
    @Column(name = "duree", nullable = false, insertable = true, updatable = true)
    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

        ReservationDemande that = (ReservationDemande) o;

        if (reservationDemandeId != that.reservationDemandeId) return false;
        if (duree != that.duree) return false;
        if (jour != null ? !jour.equals(that.jour) : that.jour != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null)
            return false;
        if (inscription != null ? !inscription.equals(that.inscription) : that.inscription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reservationDemandeId;
        result = 31 * result + (jour != null ? jour.hashCode() : 0);
        result = 31 * result + duree;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (inscription != null ? inscription.hashCode() : 0);
        return result;
    }
}
