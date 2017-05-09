package cn.sxt.service.userManager.impl;

import cn.sxt.entity.Role;
import cn.sxt.entity.Users;
import cn.sxt.exception.service.ServiceException;
import cn.sxt.mapper.RoleMapper;
import cn.sxt.mapper.UserMapper;
import cn.sxt.service.userManager.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Users loginByUserNameAndUserPswd(Users user){
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
    public Users getUsersByUser(Users user) throws ServiceException {
        return this.userMapper.selectUsersByUser(user);
    }


    /**
     *  返回分页查询返回的结果
     * @param draw
     * @param index
     * @param pageSize
     * @param user
     * @return
     * @throws ServiceException
     */
    @Override
    public Map<String, Object> getUsersListByPage(String draw,Integer index,Integer pageSize,Users user) throws ServiceException {
        Map<String,Object> params = new HashMap<String,Object>();
        if(index == null)
            index = 1;
        if(pageSize == null)
            pageSize = 3;
        params.put("start", index);
        params.put("pageSize", pageSize);
        params.put("user",user);
        List<Users> list = this.userMapper.getUserByPage(params);

        int totalCounts = this.userMapper.getUserCounts(params);

        Map<String, Object> info = new HashMap<String, Object>();
        info.put("pageData", list);
        info.put("total", totalCounts);
        info.put("draw", draw);

        return info;
    }

    /**
     * 更新用户信息
     * @param user
     */
    @Override
    public void updateUser(Users user) {
         this.userMapper.updateUser(user);
    }

    /**
     * 删除用户
     * @param user
     */
    @Override
    public void deleteUser(Users user) {
        this.userMapper.deleteUser(user);
    }

    /**
     * 获取所有的角色信息
     * @return
     * @throws ServiceException
     */
    @Override
    public List<Role> getAllRole() {
        return this.roleMapper.getAllRoles();
    }

    /**
     * 查询证件号是否存在
     * @param identity
     * @return
     */
    public Integer selectIdentity(String identity) {
        Users result = this.userMapper.selectIdentity(identity);
        if (result!=null){
            return 1;
        }else {
            return 0;
        }
    }
}
