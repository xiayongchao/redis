package com.xyc.redis.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by xyc on 2017/6/2 0002.
 */
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    private static final String KEY = "KEY";

    @RequestMapping("/index")
    public String index() {
        return "hello redis";
    }

    @RequestMapping("/set")
    public String set(@RequestParam String value) {
        this.redisTemplate.opsForValue().set(KEY, value);
        return "set value success";
    }

    @RequestMapping("/get")
    public String get() {
        String value = (String) this.redisTemplate.opsForValue().get(KEY);
        if (value == null) {
            return "get value failed";
        }
        return "the value is " + value;
    }
}
