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
public class Utilisateur {
    private String cip;
    private String nom;
    private String prenom;
    private String courriel;
    private String telephone;
    private String local;
    private Date inscription;

    @Id
    @Column(name = "cip", nullable = false, insertable = true, updatable = true, length = 8)
    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    @Basic
    @Column(name = "_nom", nullable = false, insertable = true, updatable = true, length = 2147483647)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom", nullable = false, insertable = true, updatable = true, length = 2147483647)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "courriel", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    @Basic
    @Column(name = "telephone", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "local", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
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

        Utilisateur that = (Utilisateur) o;

        if (cip != null ? !cip.equals(that.cip) : that.cip != null) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        if (courriel != null ? !courriel.equals(that.courriel) : that.courriel != null)
            return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null)
            return false;
        if (local != null ? !local.equals(that.local) : that.local != null) return false;
        if (inscription != null ? !inscription.equals(that.inscription) : that.inscription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cip != null ? cip.hashCode() : 0;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (courriel != null ? courriel.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (local != null ? local.hashCode() : 0);
        result = 31 * result + (inscription != null ? inscription.hashCode() : 0);
        return result;
    }
}
