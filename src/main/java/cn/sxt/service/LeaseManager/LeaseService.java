package cn.sxt.service.LeaseManager;

import cn.sxt.entity.Cars;
import cn.sxt.entity.Customers;
import cn.sxt.entity.Rent;
import cn.sxt.entity.Users;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/3.
 */
public interface LeaseService {
        //查询所有可租汽车信息
        List<Cars> selectAllCarsInf();
        //根据id查汽车信息
        Map<String ,Object> selectCarInfById(Integer carId, String identity);
        //创建订单
        void createRent(Rent rent);
        //查询条件汽车信息
        Cars selectCarInfByCondition(Cars car);
        //查询条件客户信息
        Customers selectCustomerInfByCondition(Customers customer);
        //查询条件用户信息
        Users selectUserInfByCondition(Users user);
        //分页查询条件订单信息
        List<Rent> selectRentInfByCondition(Map<String,Object> map);
        //查询有多少数据
        Integer selectRentInfByConditionTotal(Rent rent);
        //查询需要修改的订单信息；
        Rent selectMotifyRent(Rent rent);
        //更新出租单信息
        void updateRent(Rent rent);
}
