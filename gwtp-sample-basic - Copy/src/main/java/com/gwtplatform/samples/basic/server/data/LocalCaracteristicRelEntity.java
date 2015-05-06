package com.gwtplatform.samples.basic.server.data;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA
 * Project: gwtp-sample-basic
 * on 5/5/2015
 *
 * @author antoine
 */
@Entity
@Table(name = "local_caracteristic_rel", schema = "public", catalog = "app1_sandbox")
@IdClass(LocalCaracteristicRelEntityPK.class)
public class LocalCaracteristicRelEntity {
    private int carateristicId;
    private int localId;

    @Id
    @Column(name = "carateristic_id")
    public int getCarateristicId() {
        return carateristicId;
    }

    public void setCarateristicId(int carateristicId) {
        this.carateristicId = carateristicId;
    }

    @Id
    @Column(name = "local_id")
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

        LocalCaracteristicRelEntity that = (LocalCaracteristicRelEntity) o;

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
