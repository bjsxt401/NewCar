package cn.sxt.controller.customersManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/4/28.
 */
@Controller
@RequestMapping("/customerSystem")
public class TestCustomerControlle {
    @RequestMapping("/{path}")
    public String go(@PathVariable("path")String path){
        System.out.println("123");
        return "CustomerSystem/"+path;
    }

}
                                                      