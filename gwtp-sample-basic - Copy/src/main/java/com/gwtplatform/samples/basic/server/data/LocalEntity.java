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
@Table(name = "local", schema = "public", catalog = "app1_sandbox")
public class LocalEntity {
    private int localId;
    private Integer number;

    @Id
    @Column(name = "local_id")
    public int getLocalId() {
        return localId;
    }

    public void setLocalId(int localId) {
        this.localId = localId;
    }

    @Basic
    @Column(name = "number")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocalEntity that = (LocalEntity) o;

        if (localId != that.localId) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = localId;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }
}
