package application.controller;

import application.domain.User;
import application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import application.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);
    
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
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(model.getPassword());
        model.setPassword(encodedPassword);
        userRepository.save(model);
        logger.debug("Adding a new user " + model);
        return "register_success";
    }

    @GetMapping("/login")
    public String goLogin(HttpServletRequest request){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String postLogin(User model) {

        return "header";
    }

    @GetMapping("/header")
    public String goHeader(HttpServletRequest request){
        return "header";
    }

    @GetMapping("/cabinet")
    public String goCabinet(HttpServletRequest request){
        return "cabinet";
    }

    @GetMapping("/footer")
    public String goFooter(HttpServletRequest request){
        return "footer";
    }


}
