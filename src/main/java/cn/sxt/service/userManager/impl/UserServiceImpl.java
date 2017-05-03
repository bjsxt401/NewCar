package cn.sxt.service.userManager.impl;

import cn.sxt.entity.Role;
import cn.sxt.entity.Users;
import cn.sxt.exception.service.ServiceException;
import cn.sxt.mapper.RoleMapper;
import cn.sxt.mapper.UserMapper;
import cn.sxt.service.userManager.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by beichunming on 2017/4/28.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    public RoleMapper getRoleMapper() {
        return roleMapper;
    }

    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 通过用户名密码登录
     * @param user
     * @return
     * @throws ServiceException
     */
    @Override
    public Users loginByUserNameAndUserPswd(Users user) throws ServiceException{
        return this.userMapper.getUserByUser(user);
    }

    /**
     * 用户注册
     * @param user
     * @throws ServiceException
     */
    @Override
    public void registerUser(Users user) throws ServiceException {
        this.userMapper.addUser(user);
    }

    /**
     *  根据条件查询用户
     * @param user
     * @return
     * @throws ServiceException
     */
    @Override
    public List<Users> getUsersByUser(Users user) throws ServiceException {
        return this.userMapper.selectUsersByUser(user);
    }

    /**
     * 获取所有的角色信息
     * @return
     * @throws ServiceException
     */
    @Override
    public List<Role> getAllRole() throws ServiceException {
        return this.roleMapper.getAllRoles();
    }
}
