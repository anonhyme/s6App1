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
@Table(name = "categorie_locaux", schema = "public", catalog = "app1_sandbox")
public class CategorieLocaux {
    private BigInteger categorieId;
    private String libelle;
    private Date inscription;

    @Id
    @Column(name = "categorie_id", nullable = false, insertable = true, updatable = true, precision = 0)
    public BigInteger getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(BigInteger categorieId) {
        this.categorieId = categorieId;
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

        CategorieLocaux that = (CategorieLocaux) o;

        if (categorieId != null ? !categorieId.equals(that.categorieId) : that.categorieId != null)
            return false;
        if (libelle != null ? !libelle.equals(that.libelle) : that.libelle != null) return false;
        return !(inscription != null ? !inscription.equals(that.inscription) : that.inscription != null);

    }

    @Override
    public int hashCode() {
        int result = categorieId != null ? categorieId.hashCode() : 0;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        result = 31 * result + (inscription != null ? inscription.hashCode() : 0);
        return result;
    }
}
