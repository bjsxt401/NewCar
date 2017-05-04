package cn.sxt.mapper;

import cn.sxt.entity.Rent;

import java.util.List;

/**
 * Created by Administrator on 2017/5/4.
 */
public interface RentMapper {
    void createRent(Rent rent);
    List<Rent> selectRentInfByCondition(Rent rent);
}
