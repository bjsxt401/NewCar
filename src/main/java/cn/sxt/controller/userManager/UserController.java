package cn.sxt.controller.userManager;

import cn.sxt.entity.Role;
import cn.sxt.entity.Users;
import cn.sxt.service.userManager.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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

    /**
     * 向jsp userSystem中跳转
     * @param path
     * @return
     */
    @RequestMapping("/{path}")
    public String userDispatcher(@PathVariable("path")String path){
        return "userSystem/"+path;
    }

    /**
     * 用户登录
     * @param userName
     * @param userPwd
     * @param request
     * @return
     */
    @RequestMapping(value = "/login",method = {RequestMethod.POST})
   public String login(@RequestParam("loginuser")String userName, @RequestParam("loginpwd")String userPwd ,HttpServletRequest request){
        try {
            Users user = new Users();
            user.setUserName(userName);
            user.setUserPwd(userPwd);
            Users users = this.userService.loginByUserNameAndUserPswd(user);
            //把登录的用户信息存入到session
            HttpSession session = request.getSession();
            session.setAttribute("loginUser",users);
            //获取所有的角色信息,并存入到session中
            List<Role> roleList = this.userService.getAllRole();
            session.setAttribute("roleList",roleList);
            //System.out.println("users+====="+users+"roleList======="+roleList);
        }   catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/dispatcher/main.action";
   }
    

    /**
     * 用户注册
     * @param user
     * @return
     */
   @RequestMapping(value = "/register",method = {RequestMethod.POST})
    public String register(Users user){
       System.out.println("registerUser==================="+user);
       try {
           this.userService.registerUser(user);
           return "redirect:/user/findUser.action";
       }   catch (Exception e){
           e.printStackTrace();
           return "redirect:/user/addUser.action";
       }

   }

   @RequestMapping(value = "/queryUser",method = {RequestMethod.POST})
    public String queryUserByUser(Users user,HttpServletRequest request){
       System.out.println("user-----------======="+user);
        List<Users>usersList = null;
        try {
            usersList = this.userService.getUsersByUser(user);

            System.out.println("usersList============"+usersList);
        }   catch (Exception e){
            e.printStackTrace();
        }

        return null;
   }
}
