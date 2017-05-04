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
    //删除客户信息
    void deleteCustomer(Integer cid);
    //查询所需修改的客户信息
    Customers selectModifyCustomer(Integer cid);
    //更新客户信息
    void modifyCustomer(Customers customer);
    //更新客户密码
    void modifyCustomerPwd(Customers customer);
    //查询证件号是否被注册
    Integer selectIdentity(String identity);
    //根据证件号查询cid
    Integer selectCidByIdentity(String identity);
    //查询条件客户信息
    Customers selectCustomerInfByCondition(Customers customer);
}
