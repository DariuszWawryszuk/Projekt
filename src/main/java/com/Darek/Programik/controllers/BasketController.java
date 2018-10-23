package com.Darek.Programik.controllers;


import com.Darek.Programik.model.BookInBasket;
import com.Darek.Programik.repository.BasketRepository;
import com.Darek.Programik.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BasketController {

    @Autowired
    BasketService basketService;

    @RequestMapping("/basket")
    public String getBasket(Model model){
        List<BookInBasket> allBasket =  basketService.findAllBooks();
        model.addAttribute("basket",allBasket);
        return "basket";
    }

    @RequestMapping("/newbookinbasket")
    public String crateBook (Model model){
        model.addAttribute("bookinbasket", new BookInBasket());
        return "basketform";
    }

    @RequestMapping(value = "/basket", method = RequestMethod.POST)
    public String saveBookInBasket(BookInBasket bookInBasket){
        basketService.saveBook(bookInBasket);
        return "redirect:/basket";
    }
}
