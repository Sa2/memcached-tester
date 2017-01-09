package com.memcachedtesterclient.controller;

import com.memcachedtesterclient.model.CacheValue;
import com.memcachedtesterclient.repository.BasicMemcachedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Sa2 on 2017/01/05.
 */
@RestController
@RequestMapping("/basic")
public class BasicMemcachedController {

    @Autowired
    private BasicMemcachedRepository basicMemcachedRepository;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello! from spring";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String resolve(@RequestParam String key) {
        return basicMemcachedRepository.resolve(key);
    }

    @RequestMapping(value = "/set", method = RequestMethod.POST)
    public String store(@RequestBody CacheValue param) {
        System.out.println("Setting key is...");

        System.out.println(param.getKey());
        return basicMemcachedRepository.store(param.getKey(), param.getValue());
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String delete(@RequestParam String key) {
        return basicMemcachedRepository.deleteValue(key);
    }
}
