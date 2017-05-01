package cn.sxt.mapper;

import cn.sxt.entity.Customers;
import cn.sxt.entity.PageBean;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/28.
 */
public interface CustomersMapper {
    //注册客户
    void registerCustomer(Customers customer);
    //根据条件查询客户信息，并且分页查询
    List<Customers> selectCustomersByCondition( Map<String,Object> param);
    //由于条件查询客户信息，需要把查询的总数据查出来，并且是匹配条件的客户
    Integer totalByCondition(Customers customer);
    void deleteCustomer(Integer cid);
    Customers selectModifyCustomer(Integer cid);
    void modifyCustomer(Customers customer);
    void modifyCustomerPwd(Customers customer);
}
