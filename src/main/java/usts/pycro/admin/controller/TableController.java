package usts.pycro.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import usts.pycro.admin.bean.User;

import java.util.Arrays;
import java.util.List;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-24 11:26 AM
 */
@Controller
public class TableController {
    @GetMapping("/basic_table")
    public String basic_table() {
        int i = 10/0;
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model) {
        List<User> users = Arrays.asList(
                new User("Pycro", "123456"),
                new User("Jack", "654123"),
                new User("Crypt", "123434"),
                new User("Tom", "453234"),
                new User("Kight", "978678")
        );
        model.addAttribute("users",users);
        return "table/dynamic_table";
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
