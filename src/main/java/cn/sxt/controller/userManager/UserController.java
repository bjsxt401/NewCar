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
import java.io.PrintWriter;
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
            if (users!=null){
                //把登录的用户信息存入到session
                HttpSession session = request.getSession();
                session.setAttribute("loginUser",users);
                //获取所有的角色信息,并存入到session中
                List<Role> roleList = this.userService.getAllRole();
                session.setAttribute("roleList",roleList);
                return "redirect:/dispatcher/main.action";
            }
            

            //System.out.println("users+====="+users+"roleList======="+roleList);
        }   catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/login.jsp";
   }
    

    /**
     * 用户注册
     * @param user
     * @return
     */
   @RequestMapping(value = "/register",method = {RequestMethod.POST})
    public String register(Users user){
       //System.out.println("registerUser==================="+user);
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
      // System.out.println("user-----------======="+user);
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

       //System.out.println("user++--==="+user+"draw===="+draw+"startIndex====="+startIndex+"pageSize===="+pageSize);
       Map<String,Object> usersResult = null;
       try {
           usersResult = this.userService.getUsersListByPage(draw,Integer.parseInt(startIndex),Integer.parseInt(pageSize),user);
           String json = new Gson().toJson(usersResult);
           //System.out.println("usersResult======="+usersResult);
           return new ObjectMapper().writeValueAsString(usersResult);
           

       }   catch (Exception e){
           e.printStackTrace();
       }
       return null;
   }

    /**
     * 预更新操作
     * @param uid
     * @param request
     * @return
     */
   @RequestMapping(value = "/toUpdateUser")
   public String toUpdateUser (@RequestParam("uid")Integer uid,HttpServletRequest request){

        try {
            Users currentUser = new Users();
            currentUser.setUid(uid);
            Users user = this.userService.getUsersByUser(currentUser);
            request.setAttribute("updateUser",user);
           // System.out.println("user===---"+user);
            return "forward:/user/updateUser.action";
        }   catch (Exception e){
            e.printStackTrace();
        }
       return null;
   }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
   @RequestMapping(value = "/doUpdateUser",method = {RequestMethod.POST})
    public String doUpdateUser(Users user,HttpServletRequest request){
       //System.out.println("updateUser==---"+user);
       try {
            this.userService.updateUser(user);
            return "forward:/user/userListPage.action";
       }   catch (Exception e){
           e.printStackTrace();
       }
       return null;
   }

    /**
     * 删除
     * @param uid
     * @return
     */
   @RequestMapping(value = "/deleteUserItem")
   public String deleteUserItem(@RequestParam("uid")Integer uid,HttpServletResponse response){
       try {
           Users user = new Users();
           user.setUid(uid);
           this.userService.deleteUser(user);
           return "forward:/user/userListPage.action";
       }   catch (Exception e){
           e.printStackTrace();
       }
         return null;
   }

    /**
     * 于，，预修改，获取要修改的user的对象
     * @param uid
     * @param request
     * @return
     */
   @RequestMapping(value = "/toChangeUserPwsd")
   public  String   toChangeUserPwsd(@RequestParam("uid")Integer uid,HttpServletRequest request){
       try {
           Users user = new Users();
           user.setUid(uid);
           Users changedUser = this.userService.getUsersByUser(user);
           request.setAttribute("changedUser",changedUser);
           return "forward:/user/changeUserPwd.action";
       }   catch (Exception e){
           e.printStackTrace();
       }
       return null;
   }

    /**
     * 修改密码
     * @param
     * @return
     */
   @RequestMapping(value = "/doChangeUserPwd",method = {RequestMethod.POST})
   public String doChangeUserPwd(@RequestParam("newUserPwd")String newUserPwd,@RequestParam("userName")String userName){
       try {
           Users user = new Users();
           user.setUserPwd(newUserPwd);
           user.setUserName(userName);
           this.userService.updateUser(user);
           return "redirect:/user/findUser.action";
       }   catch (Exception e){
           e.printStackTrace();
       }
       return null;
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

}
