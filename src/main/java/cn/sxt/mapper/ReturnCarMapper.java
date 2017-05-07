package cn.sxt.mapper;

import cn.sxt.entity.Cars;
import cn.sxt.entity.CheckTable;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/6.
 */
public interface ReturnCarMapper {
    //更新汽车信息
    void updateCar(Cars car);
    //创建检查单
    void createCheckTable(CheckTable checkTable);
    //分页查询
    List<CheckTable> selectCheckTableByPage(Map<String,Object> map);
    //分页查询 总条数
    Integer selectCheckTableByPageTotal(CheckTable checkTable);
    //查询修改的检查单信息
    CheckTable modifyCheckTable(CheckTable checkTable);
    //删除检查单
    void deleteCheckTable(CheckTable checkTable);
    //更新检查单
    void updateCheckTable(CheckTable checkTable);


}
