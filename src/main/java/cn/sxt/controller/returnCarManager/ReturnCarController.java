package cn.sxt.controller.returnCarManager;

import cn.sxt.entity.Cars;
import cn.sxt.service.returnCarManager.ReturnCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by beichunming on 2017/5/5.
 */
@Controller
@RequestMapping("/returnCar")
public class ReturnCarController {
    @Autowired
    private ReturnCarService returnCarService;

    public ReturnCarService getReturnCarService() {
        return returnCarService;
    }

    public void setReturnCarService(ReturnCarService returnCarService) {
        this.returnCarService = returnCarService;
    }


}
