package cn.sxt.service.userManager.impl;

import cn.sxt.entity.Users;
import cn.sxt.exception.service.ServiceException;
import cn.sxt.mapper.UserMapper;
import cn.sxt.service.userManager.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by beichunming on 2017/4/28.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Users loginByUserNameAndUserPswd(Users user) throws ServiceException{
        return this.userMapper.getUserByUser(user);
    }
}
