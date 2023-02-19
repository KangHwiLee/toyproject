package com.kanghwi.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/setting")
public class SettingController {

    @GetMapping("/test")
    public String test(){
        return "settings/setting_test";
    }

    @ResponseBody
    @GetMapping("/download")
    public void download(){



    }

}
