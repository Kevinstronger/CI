package com.tsing.server;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/post")
public class PostMethod {
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletResponse response,
                             @RequestParam(required = true) String userName,
                             @RequestParam(required = true) String password){
        if(userName.equals("kevin")&& password.equals("123456")){
            Cookie cookie = new Cookie("status", "success");
            Map<String,String> details = new HashMap<>();
            details.put("id","116894");
            details.put("rank","10");
            details.put("mobile","1880009999");

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("user",details);
            return jsonObject.toString();

        }

        return "请输入正确的用户名或密码";

    }
}
