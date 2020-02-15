package com.bkash.se.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class BackendController {


    public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";


    @RequestMapping(path = "/hello")
    public @ResponseBody
    String sayHello() {
        log.info("GET called on /hello resource");
        return HELLO_TEXT;
    }


    // Forwards all routes to FrontEnd except: '/', '/index.html', '/api', '/api/**'
    // Required because of 'mode: history' usage in frontend routing, see README for further details
    @RequestMapping(value = "{_:^(?!index\\.html|api).$}")
    public String redirectApi() {
        log.info("URL entered directly into the Browser, so we need to redirect...");
        return "forward:/";
    }

}
