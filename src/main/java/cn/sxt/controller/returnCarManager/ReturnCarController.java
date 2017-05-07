package cn.sxt.controller.returnCarManager;

import cn.sxt.entity.*;
import cn.sxt.service.LeaseManager.Impl.LeaseServiceImpl;
import cn.sxt.service.returnCarManager.ReturnCarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.regexp.internal.RE;
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
import java.util.List;
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



    @RequestMapping("/selectCheckTableByPage")
    public String selectCheckTableByPage(Users user, CheckTable checkTable, HttpSession session, PageBean pageBean){
        pageBean.init();
        //查询用户名称查询ID放入检查单
        if(user.getUserName()!="") {
            Users userResult = this.leaseService.selectUserInfByCondition(user);
            checkTable.setCheckUserId(userResult.getUid());
        }
        //将查询条件放入session
        session.setAttribute("selectRentByPageCondition",checkTable);
        //查询信息，条件，pageBean放入map传入
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("checkTable",checkTable);
        map.put("pageBean",pageBean);
        List<CheckTable> CheckTables = this.returnCarService.selectCheckTableByPage(map);
        //查询总条数
        Integer total =  this.returnCarService.selectCheckTableByPageTotal(checkTable);
        pageBean.setTotal(total);
        pageBean.init();
        session.setAttribute("pageBean",pageBean);
        session.setAttribute("CheckTables",CheckTables);



        return "returnCarSystem/selectCheckTableByPageResult";
    }

    @RequestMapping("/selectCheckTableByPage2")
    public String selectCheckTableByPage2(HttpSession session, PageBean pageBean){

        pageBean.init();
        //将查询条件从session获取
        CheckTable checkTable = (CheckTable) session.getAttribute("selectRentByPageCondition");
        //查询信息，条件，pageBean放入map传入
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("checkTable",checkTable);
        map.put("pageBean",pageBean);
        List<CheckTable> CheckTables = this.returnCarService.selectCheckTableByPage(map);
        //查询总条数
        Integer total =  this.returnCarService.selectCheckTableByPageTotal(checkTable);
        pageBean.setTotal(total);
        pageBean.init();
        session.setAttribute("pageBean",pageBean);
        session.setAttribute("CheckTables",CheckTables);

        return "returnCarSystem/selectCheckTableByPageResult";
    }




    @RequestMapping("/modifyCheckTable")
    public String modifyCheckTable(HttpSession session,CheckTable checkTable){
        //根据ID查询检查单信息放入作用域
        CheckTable checkTableResult = this.returnCarService.modifyCheckTable(checkTable);
        //根据rentId查询
        Rent rent = new Rent();
        rent.setTableId(checkTableResult.getRentId());
        rent = this.leaseService.selectMotifyRent(rent);
        checkTableResult.setRent(rent);
        session.setAttribute("motifyCheckTable",checkTableResult);
        return "returnCarSystem/modifyCheckTable";
    }


    @RequestMapping(value = "/deleteCheckTable",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public String deleteCheckTable(CheckTable checkTable){
        System.out.println(checkTable);
        this.returnCarService.deleteCheckTable(checkTable);
        Map<String,Boolean> map = new HashMap<String,Boolean>();
        map.put("result",true);
        try {
            return  new ObjectMapper().writeValueAsString(map);
        }catch (Exception e){

        }
        return "returnCarSystem/result";
    }


    @RequestMapping("/updateCheckTable")
    public String updateCheckTable(CheckTable checkTable,Rent rent){
        System.out.println(checkTable);
        System.out.println(rent);
        //获取检查单信息更新，
        this.returnCarService.updateCheckTable(checkTable);
        //获取出租单信息更新
        this.leaseService.updateRent(rent);

        return "returnCarSystem/result";
    }

}
