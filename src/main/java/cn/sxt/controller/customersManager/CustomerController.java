package cn.sxt.controller.customersManager;

import cn.sxt.entity.Customers;
import cn.sxt.entity.PageBean;
import cn.sxt.service.customersManager.CustomersService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/28.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomersService customersService;
//    customerSystem/customerRegister.action      访问注册路径

    /**
     * 添加客户信息
     * @param customer   客户对象
     * @return 返回结果到页面
     */
    @RequestMapping("/register")
    public String registerCustomer(Customers customer){
         System.out.println(customer);
            this.customersService.registerCustomer(customer);
        return "CustomerSystem/finish";
     }

    /**
     * 根据条件查询客户信息
     * @return
     */

    @RequestMapping(value = "/selectCustomer",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public Object selectCustomer(PageBean pageBean, HttpSession session){
        Customers customer = (Customers) session.getAttribute("ConditionByCustomers");
        System.out.println(customer);
        Map<String,Object> custPage = this.customersService.selectCustomers(customer,pageBean);
        System.out.println(custPage);
        try {
            return  new ObjectMapper().writeValueAsString(custPage);
        }catch (Exception e){

        }
             return  null;
    }

    /**
     * 存储查询条件
     * @param customer
     * @param session
     * @return
     */
    @RequestMapping("/setCondition")
    public String setSelectCondition(Customers customer,HttpSession session){
        session.setAttribute("ConditionByCustomers",customer);
        return "CustomerSystem/customersByPage";
    }

    /**
     * 删除客户
     * @param cid
     */
    @RequestMapping("/deleteCustomer")
    public void deleteCustomer(Integer cid){
        this.customersService.deleteCustomer(cid);
    }

    /**
     * 查询修改的用户并放到session中 modifyCustomer
     * @return
     */
    @RequestMapping("/selectModifyCustomer")
    public String selectModifyCustomer(Integer cid,HttpSession session){
       Customers customer =  this.customersService.selectModifyCustomer(cid);
       session.setAttribute("modifyCustomer",customer);
        return "CustomerSystem/compileCustomer";
    }
    /**
     * 修改客户信息
     * @param customer
     * @return
     */
    @RequestMapping("/modifyCustomer")
    public String modifyCustomer(Customers customer){
        System.out.println(customer);
        this.customersService.modifyCustomer(customer);
        return "CustomerSystem/finish";

    }

    @RequestMapping("/modifyCustomerPwd")
    public String modifyPwd(Customers customer){
        this.customersService.modifyCustomerPwd(customer);
        return "CustomerSystem/finish";
    }
}
