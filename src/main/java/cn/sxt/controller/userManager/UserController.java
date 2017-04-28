package cn.sxt.controller.userManager;

import cn.sxt.service.userManager.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by beichunming on 2017/4/28.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


}
