package cn.sxt.mapper;

import cn.sxt.entity.Cars;

import java.util.List;
import java.util.Map;

/**
 * Created by beichunming on 2017/5/5.
 */
public interface CarMapper {
    //添加车辆
    void insertCar(Cars car);

    List<Cars> getCarsByPage(Map<String, Object> params);

    int getCarsCounts(Map<String, Object> params);

    Cars getCarByCar(Cars car);

    void updateCar(Cars car);

    void deleteCar(Integer carId);
}
