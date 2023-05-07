package usts.pycro.admin.controller;

import com.mysql.cj.log.Log;
import jdk.nashorn.internal.runtime.regexp.joni.constants.CCSTATE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import usts.pycro.admin.bean.City;
import usts.pycro.admin.bean.Employee;
import usts.pycro.admin.bean.User;
import usts.pycro.admin.service.CityService;
import usts.pycro.admin.service.EmpService;
import usts.pycro.admin.service.UserService;

import javax.servlet.http.HttpSession;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-24 10:34 AM
 */
@Controller
public class IndexController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    EmpService empService;

    @Autowired
    CityService cityService;



    @ResponseBody
    @GetMapping("/emp")
    public Employee getEmpById(@RequestParam("id") Long id) {
        return empService.getEmpById(id);
    }

    @PostMapping("/city")
    @ResponseBody
    public City insertCity(City city){
        cityService.saveCity(city);
        return city;
    }

    @ResponseBody
    @GetMapping("/city")
    public City getCityById(@RequestParam("id") Long id) {
        return cityService.getById(id);
    }

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDB() {
        String sql = "select count(*) from t_emp";
        Long cnt = jdbcTemplate.queryForObject(sql, Long.class);
        return cnt.toString();
    }

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
            return "redirect:/main.html";
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
        //Object user = session.getAttribute("loginUser");
        //if (user != null) {
        //    return "main";
        //} else {
        //    //重新回到登录界面
        //    model.addAttribute("msg", "请重新登录");
        //    return "login";
        //}
        return "main";
    }
}

