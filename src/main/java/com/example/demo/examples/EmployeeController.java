package com.example.demo.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Random;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

//    @Autowired(required = false)
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public void hello() {
        System.out.println("Hello from Spring");
    }

    @RequestMapping(value = "/hello/second", method = RequestMethod.GET)
    @ResponseBody
    public void hello2() {
        System.out.println("Hello from Spring 2");
    }

    @RequestMapping("/get")
    @ResponseBody
    public String getEmployee() {
        System.out.println("getEmployee");
        return "<h1>Employee with name</h1>: Marcin and id: " + new Random().nextInt();
    }

    @RequestMapping("/test")
    public String getTest() {
        System.out.println("getTest");
        return "/test.html";
    }

    @RequestMapping("/headers")
    @ResponseBody
    public void headers(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + " : " + value);
        }
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addEmployee(HttpServletRequest request) {
        employeeService.save();
        String name = request.getParameter("name");
        String age = request.getParameter("age");
//        int ageAsInt = Integer.parseInt(age);
        return "Employee added. Name: " + name + ", age: " + age;
    }

    @RequestMapping("/delete")
    public String delete() {
        employeeService.delete();
        return "redirect:/employee/add";
    }
}
