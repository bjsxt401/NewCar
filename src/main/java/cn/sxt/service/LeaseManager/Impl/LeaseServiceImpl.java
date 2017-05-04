package cn.sxt.service.LeaseManager.Impl;

import cn.sxt.entity.Cars;
import cn.sxt.entity.Customers;
import cn.sxt.entity.Rent;
import cn.sxt.entity.Users;
import cn.sxt.mapper.CarsMapper;
import cn.sxt.mapper.CustomersMapper;
import cn.sxt.mapper.RentMapper;
import cn.sxt.mapper.UserMapper;
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
    @Autowired
    private UserMapper userMapper;

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
    //查询条件汽车信息
    public Cars selectCarInfByCondition(Cars car) {
        Cars carResult =  this.carsMapper.selectCarInfByCondition(car);
        return carResult;
    }
    //查询条件客户信息
    public Customers selectCustomerInfByCondition(Customers customer) {
        Customers customerResult = this.customersMapper.selectCustomerInfByCondition(customer);
        return customerResult;
    }
    //查询条件用户信息
    public Users selectUserInfByCondition(Users user) {
        Users userResult = this.userMapper.selectUsersByUser(user);
        return userResult;
    }
    //查询条件订单信息
    public List<Rent> selectRentInfByCondition(Rent rent) {
        List<Rent> rents = this.rentMapper.selectRentInfByCondition(rent);
        return rents;
    }
}
