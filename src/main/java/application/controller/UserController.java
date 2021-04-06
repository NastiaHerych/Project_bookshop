package application.controller;

import application.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import application.service.UserService;
import application.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

//    @GetMapping("/users")
    @RequestMapping(path = "/users",method = RequestMethod.GET)
    public String goIndex(HttpServletRequest request){
       return "index";
    }

    @GetMapping("/register_1")
    public String goRegister(HttpServletRequest request){
        return "register_1";
    }

    @GetMapping("/login")
    public String goLogin(HttpServletRequest request){
        return "login";
    }

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
