package cn.sxt.service.LeaseManager;

import cn.sxt.entity.Cars;
import cn.sxt.entity.Rent;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/3.
 */
public interface LeaseService {
        List<Cars> selectAllCarsInf();
        Map<String ,Object> selectCarInfById(Integer carId, String identity);
        void createRent(Rent rent);
}
