package cn.sxt.service.customersManager.impl;

import cn.sxt.entity.Customers;
import cn.sxt.entity.PageBean;
import cn.sxt.mapper.CustomersMapper;
import cn.sxt.service.customersManager.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String,Object> selectCustomers(Customers customer, PageBean pageBean) {
        pageBean.init();
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("customer",customer) ;
        param.put("pageBean",pageBean);
        List<Customers> customers = this.customersMapper.selectCustomersByCondition(param);
        System.out.println(customers);

        int total = this.customersMapper.totalByCondition(customer);
        pageBean.setTotal(total);
        pageBean.init();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("customers",customers) ;
        map.put("pageBean",pageBean);
        return map;
    }

    public Customers selectModifyCustomer(Integer cid) {
        Customers customer =  this.customersMapper.selectModifyCustomer(cid);
        return customer;
    }

    public void modifyCustomer(Customers customer) {
         this.customersMapper.modifyCustomer(customer);
    }

    public void modifyCustomerPwd(Customers customer) {
            this.customersMapper.modifyCustomerPwd(customer);
    }

    public void deleteCustomer(Integer cid) {
        this.customersMapper.deleteCustomer(cid);
    }
}
