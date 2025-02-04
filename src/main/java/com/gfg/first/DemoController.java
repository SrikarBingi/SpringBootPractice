package com.gfg.first;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @Controller
// //api response can be response or a view
// @ResponseBody

@RestController //Combination of controller and ResponseBody
public class DemoController {

    @GetMapping("/Dummy")
    public String dummyCall(){
        return "DummyCall";
    }
}
