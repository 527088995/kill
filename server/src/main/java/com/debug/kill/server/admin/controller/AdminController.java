package com.debug.kill.server.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AdminController {

    private static final String prefix = "admin/";

    @RequestMapping(value = {"/index"})
    public String index() {
        return prefix + "index";
    }

    @RequestMapping(value = {"/starter"})
    public String article() {
        return prefix + "starter";
    }

    @RequestMapping(value = {"/index2"})
    public String img() {
        return prefix + "index2";
    }

    @RequestMapping(value = {"/index3"})
    public String fullwidth() {
        return prefix + "index3";
    }

}
