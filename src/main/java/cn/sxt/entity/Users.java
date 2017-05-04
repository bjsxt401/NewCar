package cn.sxt.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by beichunming on 2017/4/28.
 */
public class Users implements Serializable{
    private Integer uid;
    private  String userName;
    private  String identity;
    private  String  fullName;
    private  String  gender;
    private String   address;
    private String   phone;
    private Integer  roleid;
    private String roleName;
    private  String  userPwd;
    private  String  position;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;

        Users users = (Users) o;

        if (getUid() != null ? !getUid().equals(users.getUid()) : users.getUid() != null) return false;
        if (getUserName() != null ? !getUserName().equals(users.getUserName()) : users.getUserName() != null) return false;
        if (getIdentity() != null ? !getIdentity().equals(users.getIdentity()) : users.getIdentity() != null) return false;
        if (getFullName() != null ? !getFullName().equals(users.getFullName()) : users.getFullName() != null) return false;
        if (getGender() != null ? !getGender().equals(users.getGender()) : users.getGender() != null) return false;
        if (getAddress() != null ? !getAddress().equals(users.getAddress()) : users.getAddress() != null) return false;
        if (getPhone() != null ? !getPhone().equals(users.getPhone()) : users.getPhone() != null) return false;
        if (getRoleid() != null ? !getRoleid().equals(users.getRoleid()) : users.getRoleid() != null) return false;
        if (getRoleName() != null ? !getRoleName().equals(users.getRoleName()) : users.getRoleName() != null) return false;
        if (getUserPwd() != null ? !getUserPwd().equals(users.getUserPwd()) : users.getUserPwd() != null) return false;
        return getPosition() != null ? getPosition().equals(users.getPosition()) : users.getPosition() == null;
    }

    @Override
    public int hashCode() {
        int result = getUid() != null ? getUid().hashCode() : 0;
        result = 31 * result + (getUserName() != null ? getUserName().hashCode() : 0);
        result = 31 * result + (getIdentity() != null ? getIdentity().hashCode() : 0);
        result = 31 * result + (getFullName() != null ? getFullName().hashCode() : 0);
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getRoleid() != null ? getRoleid().hashCode() : 0);
        result = 31 * result + (getRoleName() != null ? getRoleName().hashCode() : 0);
        result = 31 * result + (getUserPwd() != null ? getUserPwd().hashCode() : 0);
        result = 31 * result + (getPosition() != null ? getPosition().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", identity='" + identity + '\'' +
                ", fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", roleid=" + roleid +
                ", roleName='" + roleName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    public Users() {
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
