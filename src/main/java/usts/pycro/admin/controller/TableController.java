package usts.pycro.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import usts.pycro.admin.bean.User;
import usts.pycro.admin.service.UserService;

import java.util.List;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-24 11:26 AM
 */
@Controller
public class TableController {
    @Autowired
    UserService userService;

    @GetMapping("/basic_table")
    public String basic_table() {
        int i = 10 / 0;
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model
    ) {
        /* List<User> users = Arrays.asList(
                new User("Pycro", "123456"),
                new User("Jack", "654123"),
                new User("Crypt", "123434"),
                new User("Tom", "453234"),
                new User("Kight", "978678")
        );
        model.addAttribute("users",users); */
        //从数据库中查询user表中的数据并展示
        List<User> userList = userService.list();
        //model.addAttribute("users", userList);

        //分页查询数据
        Page<User> userPage = new Page<>(pn, 2);
        //分页查询的结果
        Page<User> page = userService.page(userPage, null);
        model.addAttribute("page", page);
        return "table/dynamic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(
            @PathVariable("id") Long id,
            @RequestParam(value = "pn", defaultValue = "1") Integer pn,
            RedirectAttributes ra
    ) {
        userService.removeById(id);
        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }

    @GetMapping("/editable_table")
    public String editable_table() {
        return "table/editable_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table() {
        return "table/responsive_table";
    }
}
