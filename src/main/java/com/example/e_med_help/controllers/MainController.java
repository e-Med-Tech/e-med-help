package com.example.e_med_help.controllers;

import com.example.e_med_help.dtos.LoginUserDto;
import com.example.e_med_help.dtos.NewUserDto;
import com.example.e_med_help.models.Role;
import com.example.e_med_help.models.User;
import com.example.e_med_help.services.RolesServiceInterface;
import com.example.e_med_help.services.UsersServiceInterface;
import com.example.e_med_help.validators.LoginUserValidator;
import com.example.e_med_help.validators.NewUserDtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RequestMapping("/")
@Controller
public class MainController {

    @Autowired
    RolesServiceInterface rolesServiceInterface;

    @Autowired
    UsersServiceInterface usersServiceInterface;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    NewUserDtoValidator newUserDtoValidator;

    @Autowired
    LoginUserValidator loginUserValidator;

    @GetMapping
    public String welcomePage() {
        return "index";
    }

    @InitBinder("LoginUserDto")// Εδω θα βαλεις το object που θες να κανεις validate
    public void setupBinder1(WebDataBinder binder) {
        binder.addValidators(loginUserValidator);
    }

    @GetMapping(value = "/registerForm")
    public String registerForm(ModelMap mm) {
        NewUserDto newUser = new NewUserDto();
        mm.addAttribute("roles", rolesServiceInterface.getAllRoles());
        mm.addAttribute("newUser", newUser);
        return "addUser";
    }

    @GetMapping(value = "/shoppingbasket")
    public String shoppingBasket() {
        return "shoppingbasket";
    }

    @GetMapping(value = "/payment")
    public String payment() {
        return "payment";
    }

    @GetMapping(value = "/contact")
    public String contact() {
        return "contact";
    }

    @PostMapping(value = "/addUser")
    public String addUser(@Valid @ModelAttribute(name = "newUser") NewUserDto newUser,
                          BindingResult br,
                          ModelMap mm) {
        if (br.hasErrors()) {
            mm.addAttribute("roles", rolesServiceInterface.getAllRoles());
            return "addUser";
        }

        User temp = new User();
        Role role = rolesServiceInterface.getById(newUser.getRole());
        if (role != null) {
            temp.setURoleId(role);
        } else {
            return "error";
        }
        temp.setUName(newUser.getName());
        temp.setUSurname(newUser.getSurname());
        temp.setULoginname(newUser.getUsername());
        temp.setUPassword(passwordEncoder.encode(newUser.getPassword1()));
        usersServiceInterface.insertUser(temp);

        return "index";
    }

    @GetMapping(value = "/loginForm")
    public String loginForm(ModelMap mm) {
        mm.addAttribute("LoginUserDto", new LoginUserDto());
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(@Valid @ModelAttribute(name = "LoginUserDto") LoginUserDto user,
                        BindingResult br,
                        HttpSession session,
                        ModelMap mm) {
        if (br.hasErrors()) {
            return "login";
        }
        User current = usersServiceInterface.getUserByUsername(user.getLousername());
        System.out.println(current);

        session.setAttribute("user", current);

        if (current.getURoleId().getRoleId() == 2) {
            return "redirect:physician/home";
        }
        if (current.getURoleId().getRoleId() == 3) {
            return "redirect:pharmacist/home";
        }
        if (current.getURoleId().getRoleId() == 1) {
            return "redirect:/patient/home";
        } else return "login";

    }

    @ResponseBody
    @PostMapping(value = "/checkUsername/{username}")
    public boolean checkUsername(@PathVariable(name = "username") String username) {
        User user = usersServiceInterface.getUserByUsername(username);

        return (user != null);
    }

}
