package org.anonhyme.entities;

import org.anonhyme.entities.primarykey.UsagerRolePK;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA Project: salomon on 5/8/2015
 *
 * @author antoine
 */
@Entity
@Table(name = "usager_role", schema = "public", catalog = "app1_sandbox")
@IdClass(UsagerRolePK.class)
public class UsagerRole {
    private String cip;
    private int roleId;

    @Id
    @Column(name = "cip", nullable = false, insertable = true, updatable = true, length = 8)
    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    @Id
    @Column(name = "role_id", nullable = false, insertable = true, updatable = true)
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

        UsagerRole that = (UsagerRole) o;

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
