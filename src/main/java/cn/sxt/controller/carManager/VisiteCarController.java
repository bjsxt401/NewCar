package cn.sxt.controller.carManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by beichunming on 2017/5/6.
 */
@Controller
@RequestMapping("/visitCar")
public class VisiteCarController {
    @RequestMapping("/{path}")
    public String dispatcher(@PathVariable("path")String path){
        return "carSystem/"+path;
    }
}
