package com.oracle.controller;

import com.oracle.pojo.Users;
import com.oracle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class UserController {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private UserService userService;
    @Value("${cart_cookie_name}")
    private String cookieName;
    @RequestMapping("/ll")
    public String login(){
        return "login";
    }

    @RequestMapping("/rr")
    public String reg(){
        return "register";
    }
    @RequestMapping("/go")
    public String login1(String loginname, String pwd, HttpSession session, HttpServletResponse response, HttpServletRequest request){
        Users user = userService.findUser(loginname, pwd);
        if(user!=null){
           session.setAttribute("user", user);
        }
        return "redirect:/index/in";
    }

    @RequestMapping("/register")
    public String register(String loginname, String pwd, String phone, String code, Model model){
        String key=phone;
        Users users = new Users();
        users.setCode(code);
        users.setLoginname(loginname);
        users.setPhone(phone);
        users.setPwd(pwd);
        users.setStatus("N");
        userService.addUser(users);
        String code1 = redisTemplate.boundValueOps(key).get();
        if(code1!=null){
            if(code1.equalsIgnoreCase(code)){
                userService.updateUserStatus(users.getLoginname());
            }
        }else{
             model.addAttribute("msg", "注册超时");
             return "redirect:/login/rr";
        }
    return "redirect:/index/in";
    }
}
