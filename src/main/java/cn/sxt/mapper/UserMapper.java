package cn.sxt.mapper;

import cn.sxt.entity.Users;

import java.util.List;
import java.util.Map;

/**
 * Created by beichunming on 2017/4/28.
 */
public interface UserMapper {
    Users getUserByUser(Users user);

    void addUser(Users user);


    Users selectUsersByUser(Users user);

    List<Users> getUserByPage(Map<String, Object> params);

    int getUserCounts(Map<String, Object> params);

    void updateUser(Users user);

    void deleteUser(Users user);
}
