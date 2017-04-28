package cn.sxt.service.customersManager;

import cn.sxt.entity.Customers;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/28.
 */

public interface CustomersService {
    //注册客户
      void registerCustomer(Customers customer);
}
