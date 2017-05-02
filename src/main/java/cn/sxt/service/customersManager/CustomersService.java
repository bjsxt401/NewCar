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
      //删除客户
      void deleteCustomer(Integer cid);
      //查询需要修改的用户信息
     Customers selectModifyCustomer(Integer cid);
     //更新客户信息
     void modifyCustomer(Customers customer);
     //修改客户密码
     void modifyCustomerPwd(Customers customer);
     //查询证件号是否已被注册
    boolean selectIdentity(String identity);
}
