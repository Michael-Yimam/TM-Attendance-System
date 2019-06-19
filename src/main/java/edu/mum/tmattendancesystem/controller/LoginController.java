package edu.mum.tmattendancesystem.controller;

import javax.validation.Valid;

import edu.mum.tmattendancesystem.domain.Admin;
import edu.mum.tmattendancesystem.domain.Faculty;
import edu.mum.tmattendancesystem.domain.Role;
import edu.mum.tmattendancesystem.domain.UserCredentials;
import edu.mum.tmattendancesystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserCredentialsService userService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        UserCredentials user = new UserCredentials();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid UserCredentials user, BindingResult bindingResult) {

        System.out.println("Selected role: " + user.getRole());
        ModelAndView modelAndView = new ModelAndView();

        UserCredentials userExists = userService.findByUserName(user.getUserName());
        if (userExists != null) {
            bindingResult
                    .rejectValue("userName", "error.admin",
                            "There is already a admin registered with the userName provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUserCredentials(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new UserCredentials());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }

    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView adminHome(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("User Id: " + auth.getName());
        Admin admin = adminService.findById(auth.getName());
        modelAndView.addObject("userName", "Welcome " + admin.getName() + " " + " (" + admin.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }

    @RequestMapping(value="/student/home", method = RequestMethod.GET)
    public ModelAndView studentHome(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Logged in User Id: " + auth.getName());
        UserCredentials user = userService.findByUserName(auth.getName());
        //modelAndView.addObject("userName", "Welcome " + admin.getName() + " " + admin.getLastName() + " (" + admin.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("student/home");
        return modelAndView;
    }

    @RequestMapping(value="/access-error", method = RequestMethod.GET)
    public ModelAndView accessError(){
        ModelAndView modelAndView = new ModelAndView();
/*        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserCredentials user = userService.findByUserName(auth.getName());
        //modelAndView.addObject("userName", "Welcome " + admin.getName() + " " + admin.getLastName() + " (" + admin.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        */
        modelAndView.setViewName("403");
        return modelAndView;
    }
}

