package cn.sxt.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/6.
 */
public class CheckTable implements Serializable {
     private String checkId; //检查单号
     private String checkDate;//检查日期
     private String field;//属性
     private String problem;//问题
     private Integer paying;//赔款
     private Integer checkUserId;//检查者Id
     private String rentId;//出租单编号
     private Rent rent;

    public CheckTable() {
    }

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public Integer getPaying() {
        return paying;
    }

    public void setPaying(Integer paying) {
        this.paying = paying;
    }

    public Integer getCheckUserId() {
        return checkUserId;
    }

    public void setCheckUserId(Integer checkUserId) {
        this.checkUserId = checkUserId;
    }

    public String getRentId() {
        return rentId;
    }

    public void setRentId(String rentId) {
        this.rentId = rentId;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CheckTable that = (CheckTable) o;

        if (checkId != null ? !checkId.equals(that.checkId) : that.checkId != null) return false;
        if (checkDate != null ? !checkDate.equals(that.checkDate) : that.checkDate != null) return false;
        if (field != null ? !field.equals(that.field) : that.field != null) return false;
        if (problem != null ? !problem.equals(that.problem) : that.problem != null) return false;
        if (paying != null ? !paying.equals(that.paying) : that.paying != null) return false;
        if (checkUserId != null ? !checkUserId.equals(that.checkUserId) : that.checkUserId != null) return false;
        if (rentId != null ? !rentId.equals(that.rentId) : that.rentId != null) return false;
        return rent != null ? rent.equals(that.rent) : that.rent == null;
    }

    @Override
    public int hashCode() {
        int result = checkId != null ? checkId.hashCode() : 0;
        result = 31 * result + (checkDate != null ? checkDate.hashCode() : 0);
        result = 31 * result + (field != null ? field.hashCode() : 0);
        result = 31 * result + (problem != null ? problem.hashCode() : 0);
        result = 31 * result + (paying != null ? paying.hashCode() : 0);
        result = 31 * result + (checkUserId != null ? checkUserId.hashCode() : 0);
        result = 31 * result + (rentId != null ? rentId.hashCode() : 0);
        result = 31 * result + (rent != null ? rent.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CheckTable{" +
                "checkId='" + checkId + '\'' +
                ", checkDate='" + checkDate + '\'' +
                ", field='" + field + '\'' +
                ", problem='" + problem + '\'' +
                ", paying=" + paying +
                ", checkUserId='" + checkUserId + '\'' +
                ", rentId='" + rentId + '\'' +
                ", rent=" + rent +
                '}';
    }
}
