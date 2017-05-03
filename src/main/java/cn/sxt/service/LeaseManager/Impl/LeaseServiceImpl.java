package cn.sxt.service.LeaseManager.Impl;

import cn.sxt.entity.Cars;
import cn.sxt.mapper.CarsMapper;
import cn.sxt.service.LeaseManager.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/3.
 */
@Service
public class LeaseServiceImpl implements LeaseService{

    @Autowired
    private CarsMapper carsMapper;

    public List<Cars> selectAllCarsInf() {
        List<Cars> cars = this.carsMapper.selectAllCarsInf();
        return cars;
    }

    public Cars selectCarInfById(Integer carId) {
        Cars  car = this.carsMapper.slectCarInf(carId);
        return car;
    }
}
