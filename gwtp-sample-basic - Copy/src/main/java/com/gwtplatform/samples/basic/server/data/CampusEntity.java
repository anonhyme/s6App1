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
@Table(name = "campus", schema = "public", catalog = "app1_sandbox")
public class CampusEntity {
    private int campusId;
    private String campusName;

    @Id
    @Column(name = "campus_id")
    public int getCampusId() {
        return campusId;
    }

    public void setCampusId(int campusId) {
        this.campusId = campusId;
    }

    @Basic
    @Column(name = "campus_name")
    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CampusEntity that = (CampusEntity) o;

        if (campusId != that.campusId) return false;
        if (campusName != null ? !campusName.equals(that.campusName) : that.campusName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = campusId;
        result = 31 * result + (campusName != null ? campusName.hashCode() : 0);
        return result;
    }
}
