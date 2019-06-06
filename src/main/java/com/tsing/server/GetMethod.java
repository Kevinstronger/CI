package com.tsing.server;


import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class GetMethod {
    @RequestMapping(value = "/getcookie", method = RequestMethod.GET)
    public String getCookie(HttpServletResponse response){
        Cookie cookie = new Cookie("code","10001");
        response.addCookie(cookie);
        return "恭喜你成功获得cookies信息";
    }

    @RequestMapping(value="/get/with/cookie", method = RequestMethod.GET)
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        System.out.println(cookies);
        if (Objects.isNull(cookies)){
            return "很遗憾，你没有携带cookie信息";
        }
        for(Cookie cookie:cookies){
            if (cookie.getName().equals("code")&& cookie.getValue().equals("10001")){
                return "收到cookie，访问成功！";
            }
        }
        return "这是你要的信息需要提供正确的cookie";
    }

    /**
     * 需要携带参数才能访问的get请求
     * 第一种实现方式：url?key=value&key=value
     */
    @RequestMapping(value="/get/with/param", method = RequestMethod.GET)
    public Map<String, Double> getList(@RequestParam Integer startPage,@RequestParam Integer endPage){
        Map<String,Double> goods = new HashMap<String, Double>();
        goods.put("Mac笔记本",13498.00);
        goods.put("IBM服务器",34888.00);
        goods.put("蓝牙耳机",256.90);
        return goods;
    }

    /**
     * 需要携带参数才能访问的get请求
     * 第二种实现方式：url/get/with/param/1/10
     */
    @RequestMapping(value = "/get/with/param/{startPage}/{endPage}")
    public Map<String, Double> getGoodsList(@PathVariable Integer startPage, @PathVariable Integer endPage){
        Map<String,Double> goods = new HashMap<String, Double>();
        goods.put("Tree Houses",369.50);
        goods.put("床上四件套",1088.00);
        goods.put("蓝牙耳机",256.90);
        return goods;
    }
}
