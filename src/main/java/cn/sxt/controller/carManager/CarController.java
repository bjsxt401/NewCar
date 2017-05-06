package cn.sxt.controller.carManager;

import cn.sxt.entity.Cars;
import cn.sxt.service.carManager.CarService;
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
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    public CarService getCarService() {
        return carService;
    }

    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "/addCar",method = {RequestMethod.POST})
    public String addCar(Cars car, @RequestParam("uploadFile")MultipartFile uploadFile, HttpServletRequest request){
        System.out.println("处理文件上传 - " + uploadFile);
        // 调用service中的方法.解析文件.数据入库.
        try {
            this.carService.addCar(car,uploadFile,request);
            return "forward:/dispatchCar/addCar.action";
        }   catch (Exception e){
            e.printStackTrace();
        }

        return "forward:/dispatchCar/addCar.action";
    }
//    @RequestMapping(value = "/queryCar",method = {RequestMethod.POST})
//    public String queryCar(Cars car,)
}
