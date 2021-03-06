package com.chen.controller;

import com.chen.pojo.User;
import com.chen.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by ryder on 2017/6/14.
 *
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("/loginAdmin")
    public String login(User user, Map<String, Object> map, HttpSession session){
        //todo:忘记密码页面；添加邮箱注册码认证
        Subject subject = SecurityUtils.getSubject() ;
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getPassword()) ;
        try {
            subject.login(token);
            //用户名存到session中用于前端显示
            session.setAttribute("userName",user.getUserName());
            return "redirect:/";
        }catch (Exception e){
            map.put("error","用户登陆失败：用户名或密码错误") ;
            return "login" ;
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("userName");
        //清除账号密码等工作会由shiro完成，返回主页
        return "";
    }

    @RequestMapping("/registerAdmin")
    public String register(@RequestParam("userName")String userName, @RequestParam("password")String password,@RequestParam("password2")String password2,Map<String, Object> map){
        if(userService.findUserByUsername(userName)!=null){
            map.put("errorUserName","用户创建失败：该邮箱已被注册过") ;
            //如果使用重定向，前端无法得到map的内容
            return "register";
        }
        else if(!password.equals(password2)){
            map.put("errorPassword","用户创建失败：两次密码不一致") ;
            return "register";
        }
        else {
            User new_user = new User();
            new_user.setUserName(userName);
            new_user.setPassword(password);
            userService.insertUser(new_user);
            return "forward:/loginAdmin";
        }
    }

    @RequestMapping("/changePassword")
    public String changePassword(Map<String,Object> map){
        User user = userService.findUserByUsername((String) SecurityUtils.getSubject().getPrincipal());
        map.put("user",user);
        return "change_password";
    }

    @RequestMapping("/changedPassword")
    public String changedPassword(@RequestParam("password")String password,@RequestParam("password2")String password2,Map<String, Object> map){
        if(!password.equals(password2)){
            map.put("error","密码修改失败：两次密码不一致") ;
            User user = userService.findUserByUsername((String) SecurityUtils.getSubject().getPrincipal());
            map.put("user",user);
            return "change_password";
        }
        else{
            User updated_user = new User();
            updated_user.setUserName((String) SecurityUtils.getSubject().getPrincipal());
            updated_user.setPassword(password);
            userService.updateUser(updated_user);
            UsernamePasswordToken token = new UsernamePasswordToken(updated_user.getUserName(),updated_user.getPassword()) ;
            SecurityUtils.getSubject().login(token);
            map.put("user",updated_user);
            return "change_password";
        }
    }
}