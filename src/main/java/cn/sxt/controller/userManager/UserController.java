package cn.sxt.controller.userManager;

import cn.sxt.entity.Users;
import cn.sxt.service.userManager.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by beichunming on 2017/4/28.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login",method = {RequestMethod.POST})
   public String login(@RequestParam("loginuser")String userName, @RequestParam("loginpwd")String userPwd ,HttpServletRequest request){
        try {
            Users user = new Users();
            user.setUserName(userName);
            user.setUserPwd(userPwd);
            Users users = this.userService.loginByUserNameAndUserPswd(user);

            System.out.println(users);
        }   catch (Exception e){
            e.printStackTrace();
        }

        return " commons/main";
   }
}
