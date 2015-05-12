package org.anonhyme.entities.primarykey;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA Project: salomon on 5/8/2015
 *
 * @author antoine
 */
public class UsagerRolePK implements Serializable {
    private String cip;
    private int roleId;

    @Column(name = "cip", nullable = false, insertable = true, updatable = true, length = 8)
    @Id
    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    @Column(name = "role_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsagerRolePK that = (UsagerRolePK) o;

        if (roleId != that.roleId) return false;
        if (cip != null ? !cip.equals(that.cip) : that.cip != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cip != null ? cip.hashCode() : 0;
        result = 31 * result + roleId;
        return result;
    }
}
