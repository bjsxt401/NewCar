package cn.sxt.service.userManager;

import cn.sxt.entity.Users;

/**
 * Created by beichunming on 2017/4/28.
 */
public interface UserService {
    public Users loginByUserNameAndUserPswd(Users user);
}
