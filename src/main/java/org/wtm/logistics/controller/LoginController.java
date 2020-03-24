package org.wtm.logistics.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.wtm.logistics.model.RespBean;
import org.wtm.logistics.model.User;

@RestController
public class LoginController {


    /*
    登录接口
     */
    @PostMapping("/doLogin")
    public RespBean login(@RequestBody User user){
        System.out.println(user.getAccount()+""+user.getPassword());
        UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
            //subject.getPrincipal()  存放着登录个人信息
            return RespBean.ok("登录成功",subject.getSession().getAttribute("user"));
        }catch (AuthenticationException e){
                System.out.println(e.getMessage());
        }
        return RespBean.error("登录失败！");
    }

    @GetMapping("/login")
    public RespBean login(){
        return RespBean.error("尚未登录,请登录");
    }
}
