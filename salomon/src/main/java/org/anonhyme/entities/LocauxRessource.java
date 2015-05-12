package org.anonhyme.entities;

import org.anonhyme.entities.primarykey.LocauxRessourcePK;

import java.math.BigInteger;
import java.sql.Date;

import javax.persistence.Basic;
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
@Table(name = "locaux_ressource", schema = "public", catalog = "app1_sandbox")
@IdClass(LocauxRessourcePK.class)
public class LocauxRessource {
    private String pavillonId;
    private String localId;
    private BigInteger ressourceId;
    private BigInteger quantite;
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

    @Id
    @Column(name = "ressource_id", nullable = false, insertable = true, updatable = true, precision = 0)
    public BigInteger getRessourceId() {
        return ressourceId;
    }

    public void setRessourceId(BigInteger ressourceId) {
        this.ressourceId = ressourceId;
    }

    @Basic
    @Column(name = "quantite", nullable = true, insertable = true, updatable = true, precision = 0)
    public BigInteger getQuantite() {
        return quantite;
    }

    public void setQuantite(BigInteger quantite) {
        this.quantite = quantite;
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

        LocauxRessource that = (LocauxRessource) o;

        if (pavillonId != null ? !pavillonId.equals(that.pavillonId) : that.pavillonId != null)
            return false;
        if (localId != null ? !localId.equals(that.localId) : that.localId != null) return false;
        if (ressourceId != null ? !ressourceId.equals(that.ressourceId) : that.ressourceId != null)
            return false;
        if (quantite != null ? !quantite.equals(that.quantite) : that.quantite != null)
            return false;
        if (inscription != null ? !inscription.equals(that.inscription) : that.inscription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pavillonId != null ? pavillonId.hashCode() : 0;
        result = 31 * result + (localId != null ? localId.hashCode() : 0);
        result = 31 * result + (ressourceId != null ? ressourceId.hashCode() : 0);
        result = 31 * result + (quantite != null ? quantite.hashCode() : 0);
        result = 31 * result + (inscription != null ? inscription.hashCode() : 0);
        return result;
    }
}
