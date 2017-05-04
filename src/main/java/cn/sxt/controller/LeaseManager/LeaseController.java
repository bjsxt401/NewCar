package cn.sxt.controller.LeaseManager;

import cn.sxt.entity.Cars;
import cn.sxt.entity.Customers;
import cn.sxt.entity.Rent;
import cn.sxt.entity.Users;
import cn.sxt.service.LeaseManager.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
        String identity = (String) session.getAttribute("LeaseCustomerIdentity");
        Map<String ,Object> map = this.leaseService.selectCarInfById(carId,identity);
        String beginDate =  new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Long number = System.currentTimeMillis();
        String tableId = number.toString();
        session.setAttribute("LeaseCarInf",map.get("car"));
        session.setAttribute("beginDate",beginDate);
        session.setAttribute("tableId",tableId);
        session.setAttribute("LeaseCustomerId",map.get("cId"));
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

    /**
     * 生成订单并返回
     * @param rent  接收订单信息存储  并修改车辆出租状态
     * @return
     */
    @RequestMapping("/createRent")
    public String createTheRent(Rent rent){
        this.leaseService.createRent(rent);
        return "carBusinessSystem/selectCar";
    }

    
    @RequestMapping("/selectRentByPage")
    public String selectRentByPage(Rent rent, Cars car, Customers customer, Users user){
        System.out.println(rent);
        if (car.getCarNumber()!=""){
           //根据车号 查询car相关信息放到rent里
            Cars carResult = this.leaseService.selectCarInfByCondition(car);
            rent.setCar(carResult);
        }
        if (customer.getIdentity()!=""){
            //根据身份证号 查询customer相关信息放到rent里
            Customers customerResult = this.leaseService.selectCustomerInfByCondition(customer);
            rent.setCustomers(customerResult);
        }
        if (user.getUserName()!=""){
            //根据username 查询user相关信息放到rent里
            Users userResult = this.leaseService.selectUserInfByCondition(user);
            rent.setUser(userResult);
        }
        List<Rent> rents = this.leaseService.selectRentInfByCondition(rent);
        System.out.println(rents);
        return "carBusinessSystem/selectCar";
    }
}
