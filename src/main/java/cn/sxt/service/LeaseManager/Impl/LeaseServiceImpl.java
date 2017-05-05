package cn.sxt.service.LeaseManager.Impl;

import cn.sxt.entity.Cars;
import cn.sxt.entity.Customers;
import cn.sxt.entity.Rent;
import cn.sxt.entity.Users;
import cn.sxt.mapper.RentCarsMapper;
import cn.sxt.mapper.CustomersMapper;
import cn.sxt.mapper.RentMapper;
import cn.sxt.mapper.UserMapper;
import cn.sxt.service.LeaseManager.LeaseService;
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
    private RentCarsMapper rentCarsMapper;
    @Autowired
    private RentMapper rentMapper;
    @Autowired
    private CustomersMapper customersMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询能够出租的车辆信息
     * @return
     */
    public List<Cars> selectAllCarsInf() {
        List<Cars> cars = this.rentCarsMapper.selectAllCarsInf();
        return cars;
    }

    /**
     * 根据Id查询车辆信息，
     * 并将客户证件号存到session
     * @param carId
     * @param identity
     * @return
     */
    public Map<String ,Object> selectCarInfById(Integer carId, String identity) {
        Map<String ,Object> map = new HashMap<String ,Object>();
        Cars  car = this.rentCarsMapper.slectCarInf(carId);
        map.put("car",car);
        Integer cid = this.customersMapper.selectCidByIdentity(identity);
        map.put("cId",cid);
        return map;
    }

    /**
     * 创建出租单
     * @param rent
     */
    public void createRent(Rent rent) {
       this.rentMapper.createRent(rent);
       Cars car = new Cars();
       car.setCarId(Integer.parseInt(rent.getCarId()));
       car.setIsrenting("出租中");
       this.rentCarsMapper.changeCarRenting(car);
    }
    //查询条件汽车信息
    public Cars selectCarInfByCondition(Cars car) {
        Cars carResult =  this.rentCarsMapper.selectCarInfByCondition(car);
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
    public List<Rent> selectRentInfByCondition(Map<String,Object> map) {
        List<Rent> rents = this.rentMapper.selectRentInfByCondition(map);
        return rents;
    }

    /**
     * 根据条件查询订单的总条数
     * @param rent
     * @return
     */
    public Integer selectRentInfByConditionTotal(Rent rent) {
       Integer total = this.rentMapper.selectRentInfByConditionTotal(rent);
        return total;
    }

    /**
     * 查询需要修改的订单信息
     * @param rent
     * @return
     */
    public Rent selectMotifyRent(Rent rent) {
        Rent rentResult = this.rentMapper.selectRent(rent);
        return rentResult;
    }

    /**
     * 更新出租单信息
     * @param rent
     */
    public void updateRent(Rent rent) {
       this.rentMapper.updateRent(rent);
    }
}
