package cn.sxt.service.customersManager.cn.sxt.service.customersManager.impl;

import cn.sxt.entity.Customers;
import cn.sxt.mapper.CustomersMapper;
import cn.sxt.service.customersManager.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/28.
 */
@Service
public class CustomersServiceImpl implements CustomersService {
    @Autowired
     private CustomersMapper customersMapper;
    public void registerCustomer(Customers customer) {
              this.customersMapper.registerCustomer(customer);
    }
}
