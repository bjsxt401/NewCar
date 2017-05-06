package cn.sxt.service.carManager;

import cn.sxt.entity.Cars;
import cn.sxt.exception.service.ServiceException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by beichunming on 2017/5/5.
 */
public interface CarService {
    void addCar(Cars car, MultipartFile uploadFile, HttpServletRequest request) throws ServiceException;
}
