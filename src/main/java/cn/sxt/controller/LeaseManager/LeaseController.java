package cn.sxt.controller.LeaseManager;

import cn.sxt.entity.*;
import cn.sxt.service.LeaseManager.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
    @RequestMapping("/setRentInf")
    public String setRentInf(Rent rent){
        this.leaseService.createRent(rent);
        return "carBusinessSystem/selectCar";
    }




    @RequestMapping("/selectRentByPage")
    public String selectRentByPage(Rent rent, Cars car, Customers customer, Users user, HttpSession session){
        if (car.getCarNumber()!=""){
           //根据车号 查询carid放到rent里
            Cars carResult = this.leaseService.selectCarInfByCondition(car);
            rent.setCarId(carResult.getCarId().toString());
        }
        if (customer.getIdentity()!=""){
            //根据身份证号 查询customerid放到rent里
            Customers customerResult = this.leaseService.selectCustomerInfByCondition(customer);
            Integer id = customerResult.getId();
            rent.setcId(id.toString());
        }
        if (user.getUserName()!=""){
            //根据username 查询userID放到rent里
            Users userResult = this.leaseService.selectUserInfByCondition(user);
            rent.setuId(userResult.getUid().toString());
        }
        session.setAttribute("selectRentInfCondition",rent);
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(1);
        pageBean.setPageSize(5);
        pageBean.init();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("rent",rent);
        map.put("pageBean",pageBean);
        List<Rent> rents = this.leaseService.selectRentInfByCondition(map);
        Integer total = this.leaseService.selectRentInfByConditionTotal(rent);
        pageBean.setTotal(total);
        pageBean.init();
        session.setAttribute("rents",rents);
        session.setAttribute("pageBean",pageBean);
        return "carBusinessSystem/selectRentsByPageResult";
    }
    @RequestMapping("/selectRentByPage2")
    public String selectRentByPage2(PageBean pageBean,HttpSession session){
        Rent rent = (Rent) session.getAttribute("selectRentInfCondition");
        pageBean.init();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("rent",rent);
        map.put("pageBean",pageBean);
        List<Rent> rents = this.leaseService.selectRentInfByCondition(map);
        Integer total = this.leaseService.selectRentInfByConditionTotal(rent);
        pageBean.setTotal(total);
        pageBean.init();
        session.setAttribute("rents",rents);
        session.setAttribute("pageBean",pageBean);
        return "carBusinessSystem/selectRentsByPageResult";
    }


    /**
     * 查询需要更改的出租单信息
     * @param rent
     * @param session
     * @return
     */

    @RequestMapping("/modifyRent")
    public String modifyRent(Rent rent,HttpSession session){
        Rent rentResult = this.leaseService.selectMotifyRent(rent);
        session.setAttribute("motifyRent",rentResult);
        return "carBusinessSystem/modifyRent";
    }


    /**
     * 更新出租单信息
     * @return
     */
    @RequestMapping("/updateRent")
    public String updateRent(Rent rent){
        this.leaseService.updateRent(rent);
        return "carBusinessSystem/result";
    }
}
