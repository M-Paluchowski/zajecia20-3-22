package com.example.demo.excercises.first;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @RequestMapping("/testy/test1")
    @ResponseBody
    public String hello(HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);

        return "Cześć tutaj Marcin. Wszystko działa";
    }
}
