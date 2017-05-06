package cn.sxt.service.carManager;

import cn.sxt.entity.Cars;
import cn.sxt.exception.service.ServiceException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by beichunming on 2017/5/5.
 */
public interface CarService {
    void addCar(Cars car, MultipartFile uploadFile, HttpServletRequest request) throws ServiceException;

    Map<String,Object> getCarsListByPage(String draw, Integer startIndex, Integer pageSize, Cars car) throws ServiceException;

    Cars getCarByCar(Cars car) throws ServiceException;

    void updateCar(Cars car, MultipartFile uploadFile, HttpServletRequest request) throws ServiceException;

    void deleteCar(Integer carId) throws  ServiceException;
}
