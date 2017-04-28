package cn.sxt.entity;

/**
 * Created by Administrator on 2017/4/28.
 */
public class Customers {
    private int id;               //客户ID
    private String identity;      //身份证号
    private String custName;      //客户姓名
    private String gender;           //性别
    private String address;       //地址
    private String phone;         //电话
    private String career;        //职业
    private String password;      //密码

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String idrntity) {
        this.identity = idrntity;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
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

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customers customers = (Customers) o;

        if (id != customers.id) return false;
        if (identity != null ? !identity.equals(customers.identity) : customers.identity != null) return false;
        if (custName != null ? !custName.equals(customers.custName) : customers.custName != null) return false;
        if (gender != null ? !gender.equals(customers.gender) : customers.gender != null) return false;
        if (address != null ? !address.equals(customers.address) : customers.address != null) return false;
        if (phone != null ? !phone.equals(customers.phone) : customers.phone != null) return false;
        if (career != null ? !career.equals(customers.career) : customers.career != null) return false;
        return password != null ? password.equals(customers.password) : customers.password == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (identity != null ? identity.hashCode() : 0);
        result = 31 * result + (custName != null ? custName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (career != null ? career.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Customers() {
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", identity='" + identity + '\'' +
                ", custName='" + custName + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", career='" + career + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Customers(String identity, String custName, String gender, String address, String phone, String career, String password) {
        this.identity = identity;
        this.custName = custName;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.career = career;
        this.password = password;
    }
}
