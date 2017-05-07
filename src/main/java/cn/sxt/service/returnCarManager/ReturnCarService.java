package cn.sxt.service.returnCarManager;

import cn.sxt.entity.Cars;
import cn.sxt.entity.CheckTable;
import cn.sxt.entity.Rent;
import cn.sxt.exception.service.ServiceException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by beichunming on 2017/5/4.
 */
public interface ReturnCarService {
    //查询出租单号是否存在
    boolean selectTableId(Rent rent);
    //查询出租单信息，生成检查单
    Rent selectRentToCreateCheckTable(Rent rent);
    //更新汽车信息
    void uodateCar(Cars car);
    //更新订单信息
    void uodateRent(Rent rent);
    //创建检查单
    void createCheckTable(CheckTable checkTable);
    //分页查询检查但信息
    List<CheckTable> selectCheckTableByPage(Map<String,Object> map);
    //分页总条数
    Integer selectCheckTableByPageTotal(CheckTable checkTable);
    //查询修改的检查单信息
    CheckTable modifyCheckTable(CheckTable checkTable);
    //删除检查单
    void deleteCheckTable(CheckTable checkTable);
    //更新检查单
    void updateCheckTable(CheckTable checkTable);

}
