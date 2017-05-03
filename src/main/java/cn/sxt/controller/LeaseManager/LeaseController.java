package cn.sxt.controller.LeaseManager;

import cn.sxt.entity.Cars;
import cn.sxt.service.LeaseManager.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/3.
 */
@Controller
@RequestMapping("/lease")
public class LeaseController {
    @Autowired
    private LeaseService leaseService;

    /**
     * 选择完想要租赁的车辆，跳转至生成订单页面
     * @return
     */
    @RequestMapping("/selectedCar")
    public String selectedLeaseCar(Integer carId,HttpSession session){
        Cars car = this.leaseService.selectCarInfById(carId);
        String beginDate =  new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Long number = System.currentTimeMillis();
        String tableId = number.toString();
        session.setAttribute("LeaseCarInf",car);
        session.setAttribute("beginDate",beginDate);
        session.setAttribute("tableId",tableId);
        return "carBusinessSystem/rent";
    }

    /**
     * 去选择所要租赁的车
     * @param identity   要租车的客户证件号
     * @return
     */
    @RequestMapping("/selectCar")
    public String lookCars(String identity, HttpSession session){
        session.setAttribute("LeaseCustomerIdentity",identity);
        List<Cars> carsInf = this.leaseService.selectAllCarsInf();
        session.setAttribute("carsInf",carsInf);
        return "carBusinessSystem/selectCar";
    }
}
