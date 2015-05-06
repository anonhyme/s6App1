package com.gwtplatform.samples.basic.server.data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA
 * Project: gwtp-sample-basic
 * on 5/5/2015
 *
 * @author antoine
 */
public class LocalCaracteristicRelEntityPK implements Serializable {
    private int carateristicId;
    private int localId;

    @Column(name = "carateristic_id")
    @Id
    public int getCarateristicId() {
        return carateristicId;
    }

    public void setCarateristicId(int carateristicId) {
        this.carateristicId = carateristicId;
    }

    @Column(name = "local_id")
    @Id
    public int getLocalId() {
        return localId;
    }

    public void setLocalId(int localId) {
        this.localId = localId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocalCaracteristicRelEntityPK that = (LocalCaracteristicRelEntityPK) o;

        if (carateristicId != that.carateristicId) return false;
        if (localId != that.localId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = carateristicId;
        result = 31 * result + localId;
        return result;
    }
}
