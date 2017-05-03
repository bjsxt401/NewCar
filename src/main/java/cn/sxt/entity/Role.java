package cn.sxt.entity;

import java.io.Serializable;

/**
 * Created by beichunming on 2017/5/2.
 */
public class Role implements Serializable{
    private Integer roleid;
    private String  roleName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;

        Role role = (Role) o;

        if (getRoleid() != null ? !getRoleid().equals(role.getRoleid()) : role.getRoleid() != null) return false;
        return getRoleName() != null ? getRoleName().equals(role.getRoleName()) : role.getRoleName() == null;
    }

    @Override
    public int hashCode() {
        int result = getRoleid() != null ? getRoleid().hashCode() : 0;
        result = 31 * result + (getRoleName() != null ? getRoleName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleid=" + roleid +
                ", roleName='" + roleName + '\'' +
                '}';
    }

    public Role() {
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
