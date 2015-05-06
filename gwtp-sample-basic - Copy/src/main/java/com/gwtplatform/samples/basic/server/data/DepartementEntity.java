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
@Table(name = "departement", schema = "public", catalog = "app1_sandbox")
public class DepartementEntity {
    private int departementId;
    private String departementName;

    @Id
    @Column(name = "departement_id")
    public int getDepartementId() {
        return departementId;
    }

    public void setDepartementId(int departementId) {
        this.departementId = departementId;
    }

    @Basic
    @Column(name = "departement_name")
    public String getDepartementName() {
        return departementName;
    }

    public void setDepartementName(String departementName) {
        this.departementName = departementName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartementEntity that = (DepartementEntity) o;

        if (departementId != that.departementId) return false;
        if (departementName != null ? !departementName.equals(that.departementName) : that.departementName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = departementId;
        result = 31 * result + (departementName != null ? departementName.hashCode() : 0);
        return result;
    }
}
