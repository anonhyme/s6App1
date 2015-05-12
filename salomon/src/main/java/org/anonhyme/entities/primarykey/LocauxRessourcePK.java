package org.anonhyme.entities.primarykey;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA Project: salomon on 5/8/2015
 *
 * @author antoine
 */
public class LocauxRessourcePK implements Serializable {
    private String pavillonId;
    private String localId;
    private BigInteger ressourceId;

    @Column(name = "pavillon_id", nullable = false, insertable = true, updatable = true, length = 2)
    @Id
    public String getPavillonId() {
        return pavillonId;
    }

    public void setPavillonId(String pavillonId) {
        this.pavillonId = pavillonId;
    }

    @Column(name = "local_id", nullable = false, insertable = true, updatable = true, length = 2147483647)
    @Id
    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    @Column(name = "ressource_id", nullable = false, insertable = true, updatable = true, precision = 0)
    @Id
    public BigInteger getRessourceId() {
        return ressourceId;
    }

    public void setRessourceId(BigInteger ressourceId) {
        this.ressourceId = ressourceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocauxRessourcePK that = (LocauxRessourcePK) o;

        if (pavillonId != null ? !pavillonId.equals(that.pavillonId) : that.pavillonId != null)
            return false;
        if (localId != null ? !localId.equals(that.localId) : that.localId != null) return false;
        if (ressourceId != null ? !ressourceId.equals(that.ressourceId) : that.ressourceId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pavillonId != null ? pavillonId.hashCode() : 0;
        result = 31 * result + (localId != null ? localId.hashCode() : 0);
        result = 31 * result + (ressourceId != null ? ressourceId.hashCode() : 0);
        return result;
    }
}
