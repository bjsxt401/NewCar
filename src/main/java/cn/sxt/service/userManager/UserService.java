package cn.sxt.service.userManager;

import cn.sxt.entity.Role;
import cn.sxt.entity.Users;
import cn.sxt.exception.service.ServiceException;

import javax.sql.rowset.serial.SerialException;
import java.util.List;
import java.util.Map;

/**
 * Created by beichunming on 2017/4/28.
 */
public interface UserService {
    public Users loginByUserNameAndUserPswd(Users user) throws SerialException,ServiceException;

    public List<Role>getAllRole() throws ServiceException;

    void registerUser(Users user) throws ServiceException;

    Users getUsersByUser(Users user) throws ServiceException;

    Map<String,Object> getUsersListByPage(String draw,Integer startIndex,Integer pageSize,Users user) throws ServiceException;

    void updateUser(Users user);

    void deleteUser(Users user);
}
