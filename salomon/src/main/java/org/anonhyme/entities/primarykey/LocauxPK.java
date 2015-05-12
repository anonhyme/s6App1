package org.anonhyme.entities.primarykey;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA Project: salomon on 5/8/2015
 *
 * @author antoine
 */
public class LocauxPK implements Serializable {
    private String pavillonId;
    private String localId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocauxPK locauxPK = (LocauxPK) o;

        if (pavillonId != null ? !pavillonId.equals(locauxPK.pavillonId) : locauxPK.pavillonId != null)
            return false;
        if (localId != null ? !localId.equals(locauxPK.localId) : locauxPK.localId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pavillonId != null ? pavillonId.hashCode() : 0;
        result = 31 * result + (localId != null ? localId.hashCode() : 0);
        return result;
    }
}
