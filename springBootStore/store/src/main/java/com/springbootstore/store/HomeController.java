package com.springbootstore.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static java.lang.System.*;

@Controller
public class HomeController {

    @Value("${spring.application.name}")
    private String appName;

    @RequestMapping("/")
    public String index() {
        out.println("appName: " + appName);
        return "index.html";
    }
}
