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
@Table(name = "dispo_day_relationship", schema = "public", catalog = "app1_sandbox")
@IdClass(DispoDayRelationshipEntityPK.class)
public class DispoDayRelationshipEntity {
    private int dispoId;
    private int dayId;

    @Id
    @Column(name = "dispo_id")
    public int getDispoId() {
        return dispoId;
    }

    public void setDispoId(int dispoId) {
        this.dispoId = dispoId;
    }

    @Id
    @Column(name = "day_id")
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

        DispoDayRelationshipEntity that = (DispoDayRelationshipEntity) o;

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
