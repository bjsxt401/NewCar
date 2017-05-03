package cn.sxt.controller.LeaseManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/5/3.
 */
@Controller
@RequestMapping("/carBusinessSystem")
public class VisitCarBusinessSystem {
    @RequestMapping("/{path}")
    public String go(@PathVariable("path")String path){
        return "carBusinessSystem/"+path;
    }

}
