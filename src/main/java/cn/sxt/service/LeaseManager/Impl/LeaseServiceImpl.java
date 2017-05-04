package cn.sxt.service.LeaseManager.Impl;

import cn.sxt.entity.Cars;
import cn.sxt.entity.Rent;
import cn.sxt.mapper.CarsMapper;
import cn.sxt.mapper.CustomersMapper;
import cn.sxt.mapper.RentMapper;
import cn.sxt.service.LeaseManager.LeaseService;
import org.apache.ibatis.ognl.IntHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/3.
 */
@Service
public class LeaseServiceImpl implements LeaseService{

    @Autowired
    private CarsMapper carsMapper;
    @Autowired
    private RentMapper rentMapper;
    @Autowired
    private CustomersMapper customersMapper;

    public List<Cars> selectAllCarsInf() {
        List<Cars> cars = this.carsMapper.selectAllCarsInf();
        return cars;
    }

    public Map<String ,Object> selectCarInfById(Integer carId, String identity) {
        Map<String ,Object> map = new HashMap<String ,Object>();
        Cars  car = this.carsMapper.slectCarInf(carId);
        map.put("car",car);
        Integer cid = this.customersMapper.selectCidByIdentity(identity);
        map.put("cId",cid);
        return map;
    }

    public void createRent(Rent rent) {
       this.rentMapper.createRent(rent);
       Cars car = new Cars();
       car.setCarId(Integer.parseInt(rent.getCarId()));
       car.setIsrenting("出租中");
       this.carsMapper.changeCarRenting(car);
    }
}
