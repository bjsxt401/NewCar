package cn.sxt.controller.userManager;

import cn.sxt.entity.Role;
import cn.sxt.entity.Users;
import cn.sxt.service.userManager.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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

    /**
     * 用户查询页跳转，传 user 对象，
     * @param user
     * @param request
     * @return
     */
   @RequestMapping(value = "/queryUser",method = {RequestMethod.POST})
    public String queryUserByUser(Users user,HttpServletRequest request){
       System.out.println("user-----------======="+user);
       HttpSession session = request.getSession();
       session.setAttribute("queryUser",user);
        return "forward:/user/userListPage.action";
   }


    /**
     * 分页查询
     * @param request
     */
   @RequestMapping(value = "/displayUserList",method = {RequestMethod.POST,RequestMethod.GET})
   @ResponseBody
    public String displayUserList(HttpServletRequest request){
       // get the selected user
       Users user = (Users) request.getSession().getAttribute("queryUser");
       //直接返回前台
       String draw = request.getParameter("draw");
       //数据起始位置
       String startIndex = request.getParameter("startIndex");
       //数据长度
       String pageSize = request.getParameter("pageSize");

       System.out.println("user++--==="+user+"draw===="+draw+"startIndex====="+startIndex+"pageSize===="+pageSize);
//       //定义列名
//       String[] cols = {"uid","loginame", "identity","fullname","position","gender","role",};


       Map<String,Object> usersResult = null;
       try {
           usersResult = this.userService.getUsersListByPage(draw,Integer.parseInt(startIndex),Integer.parseInt(pageSize),user);
           String json = new Gson().toJson(usersResult);
           System.out.println("usersResult======="+usersResult);
           return new ObjectMapper().writeValueAsString(usersResult);
           

       }   catch (Exception e){
           e.printStackTrace();
       }
       return null;
   }

}
