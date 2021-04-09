package application.controller;

import application.domain.Bookshop;
import application.domain.User;
import application.service.BookshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BookshopController {

    @Autowired
    BookshopService bookshopService;

    @GetMapping("/bookshop")
    public String showAll(HttpServletRequest request) {
        return "index";
    }
}
