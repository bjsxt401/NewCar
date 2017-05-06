package cn.sxt.controller.returnCarManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by beichunming on 2017/5/5.
 */
@Controller
@RequestMapping("/returnCarSystem")
public class DispatchCarController {
    @RequestMapping("/{path}")
    public String dispatcher(@PathVariable("path")String path){
        return "returnCarSystem/"+path;
    }
}
