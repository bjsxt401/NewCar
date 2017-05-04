package cn.sxt.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/3.
 */
public class Rent implements Serializable{
     private String tableId;//    出租单编号
     private String uId;   //    服务人员编号
     private String cId;    //     客户号
     private String carId;    //    车号
     private String imprest;    //     预付金
     private String shouldPayPrice;//    应付金
     private String price;  //实际付款
     private String  beginDate ;  //起租日期
     private String  shouldReturnDate ;//应归还日期
     private String  returnDate ; //实际归还日期
     private String rentFlag;//订单状态
     private Cars car;
     private Customers customers;
     private Users user;

    public Cars getCar() {
        return car;
    }

    public void setCar(Cars car) {
        this.car = car;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Rent() {
    }

    public Rent(String tableId, String uId, String cId, String carId, String imprest, String shouldPayPrice, String price, String beginDate, String shouldReturnDate, String returnDate, String rentFlag) {
        this.tableId = tableId;
        this.uId = uId;
        this.cId = cId;
        this.carId = carId;
        this.imprest = imprest;
        this.shouldPayPrice = shouldPayPrice;
        this.price = price;
        this.beginDate = beginDate;
        this.shouldReturnDate = shouldReturnDate;
        this.returnDate = returnDate;
        this.rentFlag = rentFlag;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getImprest() {
        return imprest;
    }

    public void setImprest(String imprest) {
        this.imprest = imprest;
    }

    public String getShouldPayPrice() {
        return shouldPayPrice;
    }

    public void setShouldPayPrice(String shouldPayPrice) {
        this.shouldPayPrice = shouldPayPrice;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getShouldReturnDate() {
        return shouldReturnDate;
    }

    public void setShouldReturnDate(String shouldReturnDate) {
        this.shouldReturnDate = shouldReturnDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getRentFlag() {
        return rentFlag;
    }

    public void setRentFlag(String rentFlag) {
        this.rentFlag = rentFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rent rent = (Rent) o;

        if (tableId != null ? !tableId.equals(rent.tableId) : rent.tableId != null) return false;
        if (uId != null ? !uId.equals(rent.uId) : rent.uId != null) return false;
        if (cId != null ? !cId.equals(rent.cId) : rent.cId != null) return false;
        if (carId != null ? !carId.equals(rent.carId) : rent.carId != null) return false;
        if (imprest != null ? !imprest.equals(rent.imprest) : rent.imprest != null) return false;
        if (shouldPayPrice != null ? !shouldPayPrice.equals(rent.shouldPayPrice) : rent.shouldPayPrice != null)
            return false;
        if (price != null ? !price.equals(rent.price) : rent.price != null) return false;
        if (beginDate != null ? !beginDate.equals(rent.beginDate) : rent.beginDate != null) return false;
        if (shouldReturnDate != null ? !shouldReturnDate.equals(rent.shouldReturnDate) : rent.shouldReturnDate != null)
            return false;
        if (returnDate != null ? !returnDate.equals(rent.returnDate) : rent.returnDate != null) return false;
        return rentFlag != null ? rentFlag.equals(rent.rentFlag) : rent.rentFlag == null;
    }

    @Override
    public int hashCode() {
        int result = tableId != null ? tableId.hashCode() : 0;
        result = 31 * result + (uId != null ? uId.hashCode() : 0);
        result = 31 * result + (cId != null ? cId.hashCode() : 0);
        result = 31 * result + (carId != null ? carId.hashCode() : 0);
        result = 31 * result + (imprest != null ? imprest.hashCode() : 0);
        result = 31 * result + (shouldPayPrice != null ? shouldPayPrice.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (beginDate != null ? beginDate.hashCode() : 0);
        result = 31 * result + (shouldReturnDate != null ? shouldReturnDate.hashCode() : 0);
        result = 31 * result + (returnDate != null ? returnDate.hashCode() : 0);
        result = 31 * result + (rentFlag != null ? rentFlag.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "tableId='" + tableId + '\'' +
                ", uId='" + uId + '\'' +
                ", cId='" + cId + '\'' +
                ", carId='" + carId + '\'' +
                ", imprest='" + imprest + '\'' +
                ", shouldPayPrice='" + shouldPayPrice + '\'' +
                ", price='" + price + '\'' +
                ", beginDate='" + beginDate + '\'' +
                ", shouldReturnDate='" + shouldReturnDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", rentFlag='" + rentFlag + '\'' +
                ", car=" + car +
                ", customers=" + customers +
                ", user=" + user +
                '}';
    }
}
