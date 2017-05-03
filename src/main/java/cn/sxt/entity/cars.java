package cn.sxt.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/3.
 */
public class cars implements Serializable {
    private Integer carId;   //车的id
    private String carNumber; //车的牌照号
    private String carType; //车的品牌
    private String color; //车的颜色
    private String price; //价值
    private String rentPrice; //租金
    private String deposit; //押金
    private String isrenting; //租用情况
    private String description; //描述

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
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "cars{" +
                "carId=" + carId +
                ", carNumber='" + carNumber + '\'' +
                ", carType='" + carType + '\'' +
                ", color='" + color + '\'' +
                ", price='" + price + '\'' +
                ", rentPrice='" + rentPrice + '\'' +
                ", deposit='" + deposit + '\'' +
                ", isrenting='" + isrenting + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        cars cars = (cars) o;

        if (carId != null ? !carId.equals(cars.carId) : cars.carId != null) return false;
        if (carNumber != null ? !carNumber.equals(cars.carNumber) : cars.carNumber != null) return false;
        if (carType != null ? !carType.equals(cars.carType) : cars.carType != null) return false;
        if (color != null ? !color.equals(cars.color) : cars.color != null) return false;
        if (price != null ? !price.equals(cars.price) : cars.price != null) return false;
        if (rentPrice != null ? !rentPrice.equals(cars.rentPrice) : cars.rentPrice != null) return false;
        if (deposit != null ? !deposit.equals(cars.deposit) : cars.deposit != null) return false;
        if (isrenting != null ? !isrenting.equals(cars.isrenting) : cars.isrenting != null) return false;
        return description != null ? description.equals(cars.description) : cars.description == null;
    }

    @Override
    public int hashCode() {
        int result = carId != null ? carId.hashCode() : 0;
        result = 31 * result + (carNumber != null ? carNumber.hashCode() : 0);
        result = 31 * result + (carType != null ? carType.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (rentPrice != null ? rentPrice.hashCode() : 0);
        result = 31 * result + (deposit != null ? deposit.hashCode() : 0);
        result = 31 * result + (isrenting != null ? isrenting.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public cars(Integer carId, String carNumber, String carType, String color, String price, String rentPrice, String deposit, String isrenting, String description) {
        this.carId = carId;
        this.carNumber = carNumber;
        this.carType = carType;
        this.color = color;
        this.price = price;
        this.rentPrice = rentPrice;
        this.deposit = deposit;
        this.isrenting = isrenting;
        this.description = description;
    }

    public cars() {
    }
}

