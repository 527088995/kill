package com.debug.kill.server.config;/**
 * Created by Administrator on 2019/7/2.
 */

import com.debug.kill.server.service.CustomRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * shiro的通用化配置
 * @Author:debug (SteadyJack)
 * @Date: 2019/7/2 17:54
 **/
@Configuration
public class ShiroConfig {

    @Bean
    public CustomRealm customRealm(){
        return new CustomRealm();
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(customRealm());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        // shiro过滤器工厂
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager 如果不设置就无法完成认证和授权
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        // 登录请求路径 登录页面提交form表单时 表单的action写此路径
        shiroFilterFactoryBean.setLoginUrl("/to/login");
        // 登录成功跳转到登录成功页面
        shiroFilterFactoryBean.setSuccessUrl("/index");
        // 未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/error/reject.html");
        //shiroFilterFactoryBean.setUnauthorizedUrl("/warning");

        /**
         * 配置shiro拦截器链
         *
         * anon  不需要认证
         * authc 需要认证
         * user  验证通过或RememberMe登录的都可以
         *
         * 当应用开启了rememberMe时,用户下次访问时可以是一个user,但不会是authc,因为authc是需要重新认证的
         *
         * 顺序从上到下,优先级依次降低
         *
         */
        Map<String, String> filterChainDefinitionMap=new HashMap<>();
        // 所有的css文件走  anon过滤器 此过滤器代表放过拦截 不需要权限也能访问
        filterChainDefinitionMap.put("/assets/**","anon");
        // 放过登录页面拦截
        filterChainDefinitionMap.put("/toLogin", "anon");
        filterChainDefinitionMap.put("/to/login","anon");

        /// **代表所有路径 除以上路径外都拦截 authc代表权限拦截过滤器
        filterChainDefinitionMap.put("/**","authc");
        filterChainDefinitionMap.put("/kill/execute/*","authc");
        filterChainDefinitionMap.put("/item/detail/*","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

}




























