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
public class DispoDayRelationshipEntityPK implements Serializable {
    private int dispoId;
    private int dayId;

    @Column(name = "dispo_id")
    @Id
    public int getDispoId() {
        return dispoId;
    }

    public void setDispoId(int dispoId) {
        this.dispoId = dispoId;
    }

    @Column(name = "day_id")
    @Id
    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DispoDayRelationshipEntityPK that = (DispoDayRelationshipEntityPK) o;

        if (dispoId != that.dispoId) return false;
        if (dayId != that.dayId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dispoId;
        result = 31 * result + dayId;
        return result;
    }
}
