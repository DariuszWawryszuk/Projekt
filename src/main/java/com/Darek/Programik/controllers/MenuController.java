package com.Darek.Programik.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {

    @RequestMapping("/menu")
    public String handleMenu(Model model) {
        return "menu";
    }

    @RequestMapping("/menuadmin")
    public String handleUser(Model model) {
        return "menuadmin";
    }

    @RequestMapping("/menuuser")
    public String handleAdmin(Model model) {
        return "menuuser";
    }
    @RequestMapping("/menubook")
    public String handleBook(Model model) {
        return "menubook";
    }

}
