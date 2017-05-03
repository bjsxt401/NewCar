package cn.sxt.service.LeaseManager;

import cn.sxt.entity.Cars;

import java.util.List;

/**
 * Created by Administrator on 2017/5/3.
 */
public interface LeaseService {
        List<Cars> selectAllCarsInf();
        Cars selectCarInfById(Integer carId);
}
