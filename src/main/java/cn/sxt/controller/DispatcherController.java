package cn.sxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by beichunming on 2017/4/28.
 */
@Controller
@RequestMapping("/dispatcher")
public class DispatcherController {
    @RequestMapping("/{path}")
    public String dispatcher(@PathVariable("path")String path){
          return "commons/"+path;
    }
}
