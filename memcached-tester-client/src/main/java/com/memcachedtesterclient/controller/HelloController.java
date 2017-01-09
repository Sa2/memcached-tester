package com.memcachedtesterclient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sa2 on 2017/01/03.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping(method= RequestMethod.GET)
    public String hello() {
        return "Hello Spring MVC";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String memcachedConnectTest() {
        return "hello! from spring";
    }
}
