package cn.sxt.mapper;

import cn.sxt.entity.Cars;
import cn.sxt.entity.CheckTable;

/**
 * Created by Administrator on 2017/5/6.
 */
public interface ReturnCarMapper {
    //更新汽车信息
    void updateCar(Cars car);
    //创建检查单
    void createCheckTable(CheckTable checkTable);

}
