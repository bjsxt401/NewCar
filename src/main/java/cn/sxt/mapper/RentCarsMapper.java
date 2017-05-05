package cn.sxt.mapper;

import cn.sxt.entity.Cars;

import java.util.List;

/**
 * Created by Administrator on 2017/5/3.
 */
public interface RentCarsMapper {
    //查询所有汽车信息，用于租车是浏览
    List<Cars> selectAllCarsInf();
    //根据id查询指定汽车信息，用于租车时查询详细信息，也可用于其他
    Cars slectCarInf(Integer carId);
    //当汽车出租或归还，改变出租状态
    void changeCarRenting(Cars car);
    //查询条件汽车信息
    Cars selectCarInfByCondition(Cars car);
}
