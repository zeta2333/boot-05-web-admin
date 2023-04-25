package usts.pycro.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import usts.pycro.admin.bean.User;

import javax.servlet.http.HttpSession;

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
     * @param user
     * @param session
     * @return
     */
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        if (StringUtils.hasLength(user.getUserName()) && "123456".equals(user.getPassword())) {
            //保存登录成功的用户
            session.setAttribute("loginUser", user);
            //登录成功重定向到main页面
            return "redirect:main.html";
        } else {
            model.addAttribute("msg", "账号密码错误");
            return "login";
        }
    }

    /**
     * main页面
     *
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {
        Object user = session.getAttribute("loginUser");
        if (user != null) {
            return "main";
        } else {
            //重新回到登录界面
            model.addAttribute("msg", "请重新登录");
            return "login";
        }

    }
}

