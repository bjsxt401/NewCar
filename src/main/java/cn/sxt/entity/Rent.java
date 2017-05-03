package cn.sxt.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/3.
 */
public class Rent implements Serializable{
     private String tableId;//    出租单编号
     private Integer uId;   //    服务人员编号
     private Integer cId;    //     客户号
     private Integer carId;    //    车号
     private Double imprest;    //     预付金
     private Double shouldPayPrice;//    应付金
     private Double price;      //实际交付金额    
     private Date  beginDate ;  //起租日期
     private Date  shouldReturnDate ;//应归还日期
     private Date  returnDate ; //实际归还日期

    public Rent() {
    }

    public Rent(String tableId, Integer uId, Integer cId, Integer carId, Double imprest, Double shouldPayPrice, Double price, Date beginDate, Date shouldReturnDate, Date returnDate) {
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
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Double getImprest() {
        return imprest;
    }

    public void setImprest(Double imprest) {
        this.imprest = imprest;
    }

    public Double getShouldPayPrice() {
        return shouldPayPrice;
    }

    public void setShouldPayPrice(Double shouldPayPrice) {
        this.shouldPayPrice = shouldPayPrice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getShouldReturnDate() {
        return shouldReturnDate;
    }

    public void setShouldReturnDate(Date shouldReturnDate) {
        this.shouldReturnDate = shouldReturnDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "tableId='" + tableId + '\'' +
                ", uId=" + uId +
                ", cId=" + cId +
                ", carId=" + carId +
                ", imprest=" + imprest +
                ", shouldPayPrice=" + shouldPayPrice +
                ", price=" + price +
                ", beginDate=" + beginDate +
                ", shouldReturnDate=" + shouldReturnDate +
                ", returnDate=" + returnDate +
                '}';
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
        return returnDate != null ? returnDate.equals(rent.returnDate) : rent.returnDate == null;
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
        return result;
    }
}
