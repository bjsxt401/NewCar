package cn.sxt.controller.customersManager;

import cn.sxt.entity.Customers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

/**
 * Created by Administrator on 2017/4/28.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
     @RenderMapping("/register")
    public String registerCustomer(Customers customer){
return "";
     }
}
