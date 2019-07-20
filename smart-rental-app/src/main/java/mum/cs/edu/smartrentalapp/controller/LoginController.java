package mum.cs.edu.smartrentalapp.controller;

import mum.cs.edu.smartrentalapp.domain.user.User;
import mum.cs.edu.smartrentalapp.service.UserService;
import mum.cs.edu.smartrentalapp.utils.CategoryConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public String login(Model model){
        model.addAttribute("user",new User());
        return "views/home/login";
    }
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/home";
    }

    @RequestMapping(value = "/register")
    public String register(Model model){
        model.addAttribute("user",new User());
        return "views/home/register";
    }


    @PostMapping(value = "/checkLogin")
    public String checkLogin(@ModelAttribute User user, HttpSession session){
        System.out.println("user :"+user);
        User u = userService.authenticate(user);

        ModelAndView mav = new ModelAndView();

        if (u != null){
            session.setAttribute("user",u);
            Object sessionutl =session.getAttribute("url_prior_login");
            if (sessionutl != null){
                return "redirect:"+sessionutl;
            }else {

            }
            return  (u.getRole().equalsIgnoreCase("VENDOR")? "redirect:/showCategoryDetail" :"redirect:/");
        }else {
            mav.addObject("message","login failed");
            return "views/home/login";
        }

    }@PostMapping(value = "/checkRegister")
    public ModelAndView checkRegister(@ModelAttribute("user") User user){
//        User u = userService.authenticate(user);
        ModelAndView mav = new ModelAndView();
        if (user != null ){
            userService.add(user);
            mav.setViewName("views/home/login");
           // mav.setViewName("views/home/index");

        }else {
            mav.addObject("message","registration failed");
            mav.setViewName("views/home/register");
        }
        return mav;

    }


}
