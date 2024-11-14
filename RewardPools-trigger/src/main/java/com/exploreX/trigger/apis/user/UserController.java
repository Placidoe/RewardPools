//package com.exploreX.trigger.apis.user;
//
//import cn.dev33.satoken.stp.StpUtil;
//import org.springframework.web.bind.annotation.*;
//
///**
// * TODO
// *
// * @Description
// * @Author Lx
// * @Date 2024/11/4 下午8:55
// **/
//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//
//    /*登录*/
//    @PostMapping("/login")
//    public String login(@RequestParam String username, @RequestParam String password) {
//        // 验证用户名和密码
//        if ("test".equals(username) && "123456".equals(password)) {
//            // 登录成功，设置token
//            StpUtil.login(username);
//            return "登录成功";
//        } else {
//            return "用户名或密码错误";
//        }
//    }
//
//    /*获取当前用户info*/
//    @GetMapping("/userInfo")
//    public String userInfo() {
//        // 获取当前登录用户的ID
//        String loginId = StpUtil.getLoginIdAsString();
//        return "当前用户的登录ID: " + loginId;
//    }
//
//
//}
