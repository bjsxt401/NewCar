package cn.sxt.entity;

/**
 * Created by Administrator on 2017/4/28.
 */
public class Customers {
    private int id;               //客户ID
    private String idrntity;      //身份证号
    private String custName;      //客户姓名
    private String sex;           //性别
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

    public String getIdrntity() {
        return idrntity;
    }

    public void setIdrntity(String idrntity) {
        this.idrntity = idrntity;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
        if (idrntity != null ? !idrntity.equals(customers.idrntity) : customers.idrntity != null) return false;
        if (custName != null ? !custName.equals(customers.custName) : customers.custName != null) return false;
        if (sex != null ? !sex.equals(customers.sex) : customers.sex != null) return false;
        if (address != null ? !address.equals(customers.address) : customers.address != null) return false;
        if (phone != null ? !phone.equals(customers.phone) : customers.phone != null) return false;
        if (career != null ? !career.equals(customers.career) : customers.career != null) return false;
        return password != null ? password.equals(customers.password) : customers.password == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idrntity != null ? idrntity.hashCode() : 0);
        result = 31 * result + (custName != null ? custName.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (career != null ? career.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public Customers(int id, String idrntity, String custName, String sex, String address, String phone, String career, String password) {
        this.id = id;
        this.idrntity = idrntity;
        this.custName = custName;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.career = career;
        this.password = password;
    }

    public Customers() {
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", idrntity='" + idrntity + '\'' +
                ", custName='" + custName + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", career='" + career + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
