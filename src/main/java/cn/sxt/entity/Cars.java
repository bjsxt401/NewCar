package cn.sxt.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/3.
 */
public class Cars implements Serializable {
    private Integer carId;   //车的id
    private String carNumber; //车的牌照号
    private String carType; //车的品牌
    private String color; //车的颜色
    private String price; //价值
    private String rentPrice; //租金
    private String deposit; //押金
    private String isrenting; //租用情况
    private String isrentingName;//
    private String description; //描述
    private long carImageid;//图片id
    private String suffix; //图片格式后缀

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(String rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getIsrenting() {
        return isrenting;
    }

    public void setIsrenting(String isrenting) {
        this.isrenting = isrenting;
        if (isrenting.equals("0")){
            this.setIsrentingName("未出租");
        }else if (isrenting.equals("1")){
            this.setIsrentingName("已出租");
        }

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCarImageid() {
        return carImageid;
    }

    public void setCarImageid(long carImageid) {
        this.carImageid = carImageid;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getIsrentingName() {
        return isrentingName;
    }

    public void setIsrentingName(String isrentingName) {
        this.isrentingName = isrentingName;
    }

    public Cars() {
    }

    @Override
    public String toString() {
        return "Cars{" +
                "carId=" + carId +
                ", carNumber='" + carNumber + '\'' +
                ", carType='" + carType + '\'' +
                ", color='" + color + '\'' +
                ", price='" + price + '\'' +
                ", rentPrice='" + rentPrice + '\'' +
                ", deposit='" + deposit + '\'' +
                ", isrenting='" + isrenting + '\'' +
                ", isrentingName='" + isrentingName + '\'' +
                ", description='" + description + '\'' +
                ", carImageid=" + carImageid +
                ", suffix='" + suffix + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cars)) return false;

        Cars cars = (Cars) o;

        if (getCarImageid() != cars.getCarImageid()) return false;
        if (getCarId() != null ? !getCarId().equals(cars.getCarId()) : cars.getCarId() != null) return false;
        if (getCarNumber() != null ? !getCarNumber().equals(cars.getCarNumber()) : cars.getCarNumber() != null) return false;
        if (getCarType() != null ? !getCarType().equals(cars.getCarType()) : cars.getCarType() != null) return false;
        if (getColor() != null ? !getColor().equals(cars.getColor()) : cars.getColor() != null) return false;
        if (getPrice() != null ? !getPrice().equals(cars.getPrice()) : cars.getPrice() != null) return false;
        if (getRentPrice() != null ? !getRentPrice().equals(cars.getRentPrice()) : cars.getRentPrice() != null) return false;
        if (getDeposit() != null ? !getDeposit().equals(cars.getDeposit()) : cars.getDeposit() != null) return false;
        if (getIsrenting() != null ? !getIsrenting().equals(cars.getIsrenting()) : cars.getIsrenting() != null) return false;
        if (getIsrentingName() != null ? !getIsrentingName().equals(cars.getIsrentingName()) : cars.getIsrentingName() != null)
            return false;
        if (getDescription() != null ? !getDescription().equals(cars.getDescription()) : cars.getDescription() != null)
            return false;
        return getSuffix() != null ? getSuffix().equals(cars.getSuffix()) : cars.getSuffix() == null;
    }

    @Override
    public int hashCode() {
        int result = getCarId() != null ? getCarId().hashCode() : 0;
        result = 31 * result + (getCarNumber() != null ? getCarNumber().hashCode() : 0);
        result = 31 * result + (getCarType() != null ? getCarType().hashCode() : 0);
        result = 31 * result + (getColor() != null ? getColor().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getRentPrice() != null ? getRentPrice().hashCode() : 0);
        result = 31 * result + (getDeposit() != null ? getDeposit().hashCode() : 0);
        result = 31 * result + (getIsrenting() != null ? getIsrenting().hashCode() : 0);
        result = 31 * result + (getIsrentingName() != null ? getIsrentingName().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (int) (getCarImageid() ^ (getCarImageid() >>> 32));
        result = 31 * result + (getSuffix() != null ? getSuffix().hashCode() : 0);
        return result;
    }
}

