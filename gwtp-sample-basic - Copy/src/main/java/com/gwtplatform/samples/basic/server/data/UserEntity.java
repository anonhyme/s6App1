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
@Table(name = "USER", schema = "public", catalog = "app1_sandbox")
public class UserEntity {
    private String cip;
    private String userFirstname;
    private String userLastname;

    @Id
    @Column(name = "cip")
    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    @Basic
    @Column(name = "user_firstname")
    public String getUserFirstname() {
        return userFirstname;
    }

    public void setUserFirstname(String userFirstname) {
        this.userFirstname = userFirstname;
    }

    @Basic
    @Column(name = "user_lastname")
    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (cip != null ? !cip.equals(that.cip) : that.cip != null) return false;
        if (userFirstname != null ? !userFirstname.equals(that.userFirstname) : that.userFirstname != null)
            return false;
        if (userLastname != null ? !userLastname.equals(that.userLastname) : that.userLastname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cip != null ? cip.hashCode() : 0;
        result = 31 * result + (userFirstname != null ? userFirstname.hashCode() : 0);
        result = 31 * result + (userLastname != null ? userLastname.hashCode() : 0);
        return result;
    }
}
