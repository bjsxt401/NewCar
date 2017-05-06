package cn.sxt.mapper;

import cn.sxt.entity.Rent;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/4.
 */
public interface RentMapper {
    //创建订单
    void createRent(Rent rent);
    //分页查询
    List<Rent> selectRentInfByCondition(Map<String,Object> map);
    //查询总数
    Integer selectRentInfByConditionTotal(Rent rent);
    //查询出租单信息
    Rent selectRent(Rent rent);
    //更新出租单单信息
    void updateRent(Rent rent);
}
