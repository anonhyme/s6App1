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
@Table(name = "local_caracteristique", schema = "public", catalog = "app1_sandbox")
public class LocalCaracteristiqueEntity {
    private int carateristicId;
    private String description;

    @Id
    @Column(name = "carateristic_id")
    public int getCarateristicId() {
        return carateristicId;
    }

    public void setCarateristicId(int carateristicId) {
        this.carateristicId = carateristicId;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocalCaracteristiqueEntity that = (LocalCaracteristiqueEntity) o;

        if (carateristicId != that.carateristicId) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = carateristicId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
