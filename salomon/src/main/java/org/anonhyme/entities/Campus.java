package org.anonhyme.entities;

import java.math.BigInteger;
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
@Table(name = "campus", schema = "public", catalog = "app1_sandbox")
public class Campus {
    private BigInteger campusId;
    private String libelle;
    private Date inscription;

    @Id
    @Column(name = "campus_id", nullable = false, insertable = true, updatable = true, precision = 0)
    public BigInteger getCampusId() {
        return campusId;
    }

    public void setCampusId(BigInteger campusId) {
        this.campusId = campusId;
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

        Campus campus = (Campus) o;

        if (campusId != null ? !campusId.equals(campus.campusId) : campus.campusId != null)
            return false;
        if (libelle != null ? !libelle.equals(campus.libelle) : campus.libelle != null)
            return false;
        if (inscription != null ? !inscription.equals(campus.inscription) : campus.inscription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = campusId != null ? campusId.hashCode() : 0;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        result = 31 * result + (inscription != null ? inscription.hashCode() : 0);
        return result;
    }

//    public Campus(CampusDto campusDto) {
//        campusId = campusDto.getCampusId();
//        libelle = campusDto.getLibelle();
//        inscription = campusDto.getInscription();
//
//    }

}
