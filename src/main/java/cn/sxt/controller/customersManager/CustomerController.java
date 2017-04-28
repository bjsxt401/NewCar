package cn.sxt.controller.customersManager;

import cn.sxt.entity.Customers;
import cn.sxt.service.customersManager.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

/**
 * Created by Administrator on 2017/4/28.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomersService customersService;
//    customerSystem/customerRegister.action      访问注册路径
    @RequestMapping("/register")
    public String registerCustomer(Customers customer){
         System.out.println(customer);
            this.customersService.registerCustomer(customer);
        return "CustomerSystem/finish";
     }
}
