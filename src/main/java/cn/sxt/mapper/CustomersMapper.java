package cn.sxt.mapper;

import cn.sxt.entity.Customers;

import java.util.List;

/**
 * Created by Administrator on 2017/4/28.
 */
public interface CustomersMapper {
    //注册客户
    void registerCustomer(Customers customer);
    //根据条件查询客户信息，并且分页查询
    List<Customers> selectCustomersByCondition(Customers customer);
    //由于条件查询客户信息，需要把查询的总数据查出来，并且是匹配条件的客户
    Integer totalByCondition(Customers customer);
}
