package application.controller;

import application.domain.User;
import application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;
import application.service.UserService;
import application.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @RequestMapping(path = "/users",method = RequestMethod.GET)
    public String goIndex(HttpServletRequest request){
       return "index";
    }

    @GetMapping("/register")
    public String goRegister(HttpServletRequest request, Model model){
        model.addAttribute("register", new User());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String postRegister(User model){
       //model.addAttribute("register", new User());
      //  model.setId(222);
        userRepository.save(model);
        return "login";
    }

    @GetMapping("/login")
    public String goLogin(HttpServletRequest request){
        return "login";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String postLogin(User model){
//        //model.addAttribute("register", new User());
//        //  model.setId(222);
//
//        return "login";
//    }


    @GetMapping("/cabinet")
    public String goCabinet(HttpServletRequest request){
        return "cabinet";
    }

    @GetMapping("/footer")
    public String goFooter(HttpServletRequest request){
        return "footer";
    }

    @GetMapping("/header")
    public String goHeader(HttpServletRequest request){
        return "header";
    }


}
