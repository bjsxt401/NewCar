package cn.sxt.service.returnCarManager.impl;

import cn.sxt.entity.Cars;
import cn.sxt.entity.CheckTable;
import cn.sxt.entity.Rent;
import cn.sxt.exception.service.ServiceException;
import cn.sxt.mapper.RentMapper;
import cn.sxt.mapper.ReturnCarMapper;
import cn.sxt.service.returnCarManager.ReturnCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by beichunming on 2017/5/4.
 */
@Service
public class ReturnCarServiceImpl implements ReturnCarService {

    @Autowired
    private RentMapper rentMapper;
    @Autowired
    private ReturnCarMapper returnCarMapper;

    public boolean selectTableId(Rent rent) {
        Rent rentResult = this.rentMapper.selectRent(rent);
        return rentResult!=null?true:false;
    }

    public Rent selectRentToCreateCheckTable(Rent rent) {
        Rent rentResult = this.rentMapper.selectRent(rent);
        return rentResult;
    }

    public void uodateCar(Cars car) {
        this.returnCarMapper.updateCar(car);
    }

    public void uodateRent(Rent rent) {
        this.rentMapper.updateRent(rent);
    }

    public void createCheckTable(CheckTable checkTable) {
        this.returnCarMapper.createCheckTable(checkTable);
    }

    public List<CheckTable> selectCheckTableByPage(Map<String, Object> map) {
        List<CheckTable> checkTable = this.returnCarMapper.selectCheckTableByPage(map);
        return checkTable;
    }

    public Integer selectCheckTableByPageTotal(CheckTable checkTable) {
        Integer total = this.returnCarMapper.selectCheckTableByPageTotal(checkTable);
        return total;
    }

    public CheckTable modifyCheckTable(CheckTable checkTable) {
        CheckTable checkTableResult = this.returnCarMapper.modifyCheckTable(checkTable);
        return checkTableResult;
    }

    public void deleteCheckTable(CheckTable checkTable) {
        System.out.println(checkTable);
        this.returnCarMapper.deleteCheckTable(checkTable);
    }

    public void updateCheckTable(CheckTable checkTable) {
        this.returnCarMapper.updateCheckTable(checkTable);
    }
}
