package cn.sxt.service.userManager;

import cn.sxt.entity.Users;
import cn.sxt.exception.service.ServiceException;

import javax.sql.rowset.serial.SerialException;

/**
 * Created by beichunming on 2017/4/28.
 */
public interface UserService {
    public Users loginByUserNameAndUserPswd(Users user) throws SerialException,ServiceException;
}
