package cn.sxt.service.customersManager.impl;

import cn.sxt.entity.Customers;
import cn.sxt.entity.PageBean;
import cn.sxt.exception.UserSystemException;
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

    /**
     * 注册客户
     * @param customer 传入的客户信息
     */
    public void registerCustomer(Customers customer) {
        try{
            this.customersMapper.registerCustomer(customer);

        }catch(Exception e){
        }
    }

    /**
     * 分页条件查询客户信息
     * @param customer
     * @param pageBean
     * @return
     */
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

    /**
     * 查询所需更改客户信息
     * @param cid
     * @return
     */
    public Customers selectModifyCustomer(Integer cid) {
        Customers customer =  this.customersMapper.selectModifyCustomer(cid);
        return customer;
    }

    /**
     * 更新客户信息
     * @param customer
     */
    public void modifyCustomer(Customers customer) {
         this.customersMapper.modifyCustomer(customer);
    }

    /**
     * 更新客户密码
     * @param customer
     */
    public void modifyCustomerPwd(Customers customer) {
            this.customersMapper.modifyCustomerPwd(customer);
    }

    /**
     *删除客户
     * @param cid
     */
    public void deleteCustomer(Integer cid) {
        this.customersMapper.deleteCustomer(cid);
    }

    public boolean selectIdentity(String identity) {
          boolean result =    this.customersMapper.selectIdentity(identity);
        return result;
    }
}
