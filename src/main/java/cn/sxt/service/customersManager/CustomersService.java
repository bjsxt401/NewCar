package cn.sxt.service.customersManager;

import cn.sxt.entity.Customers;
import cn.sxt.entity.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/28.
 */

public interface CustomersService {
    //注册客户
      void registerCustomer(Customers customer);
      //查询客户信息
      Map<String,Object> selectCustomers(Customers customer, PageBean pageBean);
      void deleteCustomer(Integer cid);
     Customers selectModifyCustomer(Integer cid);
     void modifyCustomer(Customers customer);
     void modifyCustomerPwd(Customers customer);
}
