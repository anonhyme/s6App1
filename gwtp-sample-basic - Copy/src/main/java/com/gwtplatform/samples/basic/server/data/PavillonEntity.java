package com.gwtplatform.samples.basic.server.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA
 * Project: gwtp-sample-basic
 * on 5/5/2015
 *
 * @author antoine
 */
@Entity
@Table(name = "pavillon", schema = "public", catalog = "app1_sandbox")
public class PavillonEntity {
    private int pavillonId;

    @Id
    @Column(name = "pavillon_id")
    public int getPavillonId() {
        return pavillonId;
    }

    public void setPavillonId(int pavillonId) {
        this.pavillonId = pavillonId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PavillonEntity that = (PavillonEntity) o;

        if (pavillonId != that.pavillonId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return pavillonId;
    }
}
