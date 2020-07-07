package com.debug.kill.server.admin.controller;


import com.debug.kill.server.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestLoginController {

    private static final String prefix = "admin/pages/";
    @Autowired
    private Environment env;

    @Autowired
    private UserService userService;


    @RequestMapping(value = {"/login/toLogin"})
    public String fullwidth() {
        return prefix + "examples/login";
    }

    /**
     * 登录认证
     *
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/login/doLogin", method = RequestMethod.POST)
    public String login(@RequestParam String usernm, @RequestParam String passwd, ModelMap modelMap) {
        String errorMsg = "";
        try {
            if (!SecurityUtils.getSubject().isAuthenticated()) {
                String newPsd = new Md5Hash(passwd, env.getProperty("shiro.encrypt.password.salt")).toString();
                UsernamePasswordToken token = new UsernamePasswordToken(usernm, newPsd);
                SecurityUtils.getSubject().login(token);
            }
        } catch (UnknownAccountException e) {
            errorMsg = e.getMessage();
        } catch (DisabledAccountException e) {
            errorMsg = e.getMessage();
        } catch (IncorrectCredentialsException e) {
            errorMsg = e.getMessage();
        } catch (Exception e) {
            errorMsg = "用户登录异常，请联系管理员!";
            e.printStackTrace();
        }
        if (StringUtils.isBlank(errorMsg)) {
            return "redirect:" + prefix + "starter";
        } else {
            modelMap.addAttribute("errorMsg", errorMsg);
            return "login";
        }
    }

    /**
     * 退出登录
     *
     * @return
     */
    @RequestMapping(value = "/login/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return prefix + "examples/login"

                ;
    }
}

