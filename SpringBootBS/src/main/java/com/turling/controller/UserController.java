package com.turling.controller;

import com.turling.entity.User;
import com.turling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

   // @GetMapping("/")
   // public String toLogin(){
    //    return "login";
   // }

   //@PostMapping("/login")
    @GetMapping("/login")
    @ResponseBody
    public  String login(User user, HttpSession session){
        User u = userService.loginUser(user);
        if(u!=null){
            session.setAttribute("user",u);
           // return "redirect:/index";
            return "success";
        }else{
          // return "redirect:/";
            return "errror";
        }
    }


//    @GetMapping("/index")
//    public String index(){
//        return "index";
//    }
}
