package usts.pycro.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-24 10:34 AM
 */
@Controller
public class IndexController {
    /**
     * 登录页
     *
     * @return
     */
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    /**
     * 登录跳转首页
     *
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public String main(String username, String password) {
        //登录成功重定向到main页面
        return "redirect:main.html";
    }

    /**
     * main页面
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage() {
        return "main";
    }
}

