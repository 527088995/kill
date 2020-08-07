package com.debug.kill.modular.system.controller;

import com.debug.kill.server.admin.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexControoler extends BaseController {

    @RequestMapping(value = "/index")
    public String index() {
        return "/index.html";
    }

    @RequestMapping(value = "/index2")
    public String index2() {
        return "/index2.html";
    }

    @RequestMapping(value = "/index3")
    public String index3() {
        return "/index3.html";
    }
}
