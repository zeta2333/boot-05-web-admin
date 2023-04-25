package usts.pycro.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-24 11:26 AM
 */
@Controller
public class TableController {
    @GetMapping("/basic_table")
    public String basic_table(){
        return "table/basic_table";
    }
    @GetMapping("/dynamic_table")
    public String dynamic_table(){
        return "table/dynamic_table";
    }
    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }
    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }
}
