package cn.sxt.controller.returnCarManager;

import cn.sxt.entity.Cars;
import cn.sxt.entity.CheckTable;
import cn.sxt.entity.Rent;
import cn.sxt.entity.Users;
import cn.sxt.service.LeaseManager.Impl.LeaseServiceImpl;
import cn.sxt.service.returnCarManager.ReturnCarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.ws.resources.HttpserverMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by beichunming on 2017/5/5.
 */
@Controller
@RequestMapping("/returnCar")
public class ReturnCarController {
    @Autowired
    private ReturnCarService returnCarService;
    @Autowired
    private LeaseServiceImpl leaseService;
    /**
     * 更新出租单信息
     * @return
     */
    @RequestMapping(value = "/selectTableId",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public Object selectTableId(Rent rent){
        boolean result =  this.returnCarService.selectTableId(rent);
        Map<String,Boolean> map = new HashMap<String,Boolean>();
        map.put("hasTableId",result);
        try {
            return  new ObjectMapper().writeValueAsString(map);
        }catch (Exception e){

        }

        return null;
    }


    @RequestMapping("/createCheckTablePage")
    public String createCheckTablePage(Rent rent, HttpSession session){

        Rent rentResult =this.returnCarService.selectRentToCreateCheckTable(rent);
        String checkDate =  new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Long number = System.currentTimeMillis();
        String checkId = number.toString();
        session.setAttribute("checkRentInf",rentResult);
        session.setAttribute("checkId",checkId);
        session.setAttribute("checkDate",checkDate);


        return "returnCarSystem/createCheckTablePage";
    }



    @RequestMapping("/createCheckTable")
    public String createCheckTable(Rent rent, Cars car, Users user, CheckTable checkTable, HttpSession session){
        //查询用户ID放到检查单里
        Users userResult =  this.leaseService.selectUserInfByCondition(user);
        checkTable.setCheckUserId(userResult.getUid());
        //更新出租单信息
         this.returnCarService.uodateCar(car);
        //更新汽车信息
         this.returnCarService.uodateRent(rent);
         //插入检查单
        this.returnCarService.createCheckTable(checkTable);


        return "returnCarSystem/result";
    }

}
