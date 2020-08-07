package com.debug.kill.server.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {

    private static final String prefix = "blog/";

    @RequestMapping(value = {"/lw-index"})
    public String index() {
        return prefix + "lw-index";
    }

    @RequestMapping(value = {"/article"})
    public String article() {
        return prefix + "lw-article";
    }

    @RequestMapping(value = {"/img"})
    public String img() {
        return prefix + "lw-img";
    }

    @RequestMapping(value = {"/fullwidth"})
    public String fullwidth() {
        return prefix + "lw-article-fullwidth";
    }

    @RequestMapping(value = {"/timeline"})
    public String timeline() {
        return prefix + "lw-timeline";
    }
}
