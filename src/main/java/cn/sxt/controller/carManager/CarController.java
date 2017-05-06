package cn.sxt.controller.carManager;

import cn.sxt.entity.Cars;
import cn.sxt.service.carManager.CarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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

    /**
     * 添加车辆信息
     * @param car
     * @param uploadFile
     * @param request
     * @return
     */
    @RequestMapping(value = "/addCar",method = {RequestMethod.POST})
    public String addCar(Cars car, @RequestParam("uploadFile")MultipartFile uploadFile, HttpServletRequest request){
        System.out.println("处理文件上传 - " + uploadFile);
        // 调用service中的方法.解析文件.数据入库.
        try {
            this.carService.addCar(car,uploadFile,request);
            return "forward:/visitCar/addCar.action";
        }   catch (Exception e){
            e.printStackTrace();
        }

        return "forward:/visitCar/addCar.action";
    }

    /**
     * 查询用户跳转分页
     * @param car
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryCar",method = {RequestMethod.POST})
    public String queryCar(Cars car,HttpServletRequest request){

        request.getSession().setAttribute("queryCar",car);
        return "forward:/visitCar/carListPage.action";
    }

    /**
     * 分页查询结果
     * @param request
     * @return
     */
    @RequestMapping(value = "/displayCarList",method = {RequestMethod.GET})
    @ResponseBody
    public String displayCarList(HttpServletRequest request){

        Cars car = (Cars) request.getSession().getAttribute("queryCar");
        //直接返回前台
        String draw = request.getParameter("draw");
        //数据起始位置
        String startIndex = request.getParameter("startIndex");
        //数据长度
        String pageSize = request.getParameter("pageSize");

        System.out.println("car++--==="+car+"draw===="+draw+"startIndex====="+startIndex+"pageSize===="+pageSize);
        Map<String,Object> carsResult = null;
        try {
            carsResult = this.carService.getCarsListByPage(draw,Integer.parseInt(startIndex),Integer.parseInt(pageSize),car);
            System.out.println("carsResult==="+carsResult);
            return new ObjectMapper().writeValueAsString(carsResult);

        }   catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 预更新car信息
     * @param carid
     * @param request
     * @return
     */
    @RequestMapping(value = "/toUpdateCar")
    public String toUpdateCar (@RequestParam("carid")Integer carid,HttpServletRequest request){
        Cars car = new Cars();
        car.setCarId(carid);
        try {
            Cars modifiedCar = this.carService.getCarByCar(car);
            request.setAttribute("car",modifiedCar);
            return "forward:/visitCar/updateCar.action";
        }   catch (Exception e){
            e.printStackTrace();
        }
        return "forward:/car/findCar.action";
    }

    @RequestMapping(value = "/doUpdateCar",method = {RequestMethod.POST})
    public String doUpdateCar(Cars car, @RequestParam("uploadFile")MultipartFile uploadFile, HttpServletRequest request){
        System.out.println("car处理文件上传 - " + car);
        // 调用service中的方法.解析文件.数据入库.
        try {
            this.carService.updateCar(car,uploadFile,request);
            return "forward:/visitCar/carListPage.action";
        }   catch (Exception e){
            e.printStackTrace();
        }

        return "forward:/visitCar/carListPage.action";
    }
    @RequestMapping(value = "/doDeleteCar")
    public String doDeleteCar(@RequestParam("carid")Integer carId){
        try {
             this.carService.deleteCar(carId);
        }   catch (Exception e){
            e.printStackTrace();
        }
        return "forward:/visitCar/carListPage.action";
    }
}
