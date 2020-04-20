/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.eMedHelp.controllers;

import com.project.eMedHelp.dtos.LoginUserDto;
import com.project.eMedHelp.dtos.NewUserDto;
import com.project.eMedHelp.models.Role;
import com.project.eMedHelp.models.User;
import com.project.eMedHelp.services.RolesServiceInterface;
import com.project.eMedHelp.services.UsersServiceInterface;
import com.project.eMedHelp.validators.LoginUserValidator;
import com.project.eMedHelp.validators.NewUserDtoValidator;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *
 * @author Natasa
 */
@Controller
public class UserController {
    
     @Autowired
    RolesServiceInterface rsi;
    @Autowired
    UsersServiceInterface usi;
   
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping(value = "/")
    public String def() {
        return "index";
    }

    @Autowired
    NewUserDtoValidator val;

    @InitBinder("newUser")
    public void setupBinder(WebDataBinder binder) {
        binder.addValidators(val);
    }

     @Autowired
    LoginUserValidator logval;

    @InitBinder("LoginUserDto")// Εδω θα βαλεις το object που θες να κανεις validate
    public void setupBinder1(WebDataBinder binder) {
        binder.addValidators(logval);
    }

    @GetMapping(value = "/registerForm")
    public String registerForm(ModelMap mm) {
        NewUserDto newUser = new NewUserDto();
        mm.addAttribute("roles", rsi.getAllRoles());
        mm.addAttribute("newUser", newUser);
        return "addUser";
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
            mm.addAttribute("roles", rsi.getAllRoles());
            return "addUser";
        }

        User temp = new User();
        Role role = rsi.getById(newUser.getRole());
        if (role != null) {
            temp.setURoleId(role);
        } else {
            return "error";
        }
        temp.setUName(newUser.getName());
        temp.setUSurname(newUser.getSurname());
        temp.setULoginname(newUser.getUsername());
        temp.setUPassword(passwordEncoder.encode(newUser.getPassword1()));
        usi.insertUser(temp);

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
       
        
        User current = usi.getUserByUsername(user.getLousername());
        System.out.println(current);
       
        session.setAttribute("user", current);
        
       if (current.getURoleId().getRoleId()==2) {
       return "physician";
       } 
       if (current.getURoleId().getRoleId()==3) {
       return "pharmacybeta";
       } 
       if (current.getURoleId().getRoleId()==1) {
       return "patient";
       } else return "login";

    }

    @PostMapping(value = "/vote")
    public String insertVote(@RequestParam(name = "candidate") Integer id,
            @RequestParam(name = "rating") Integer star,
            HttpSession session) {
        User voter = (User) session.getAttribute("user");
        User candidate = usi.getUserById(id);
       // Pollvote vote = new Pollvote();
       // Date date = new Date();
      //  vote.setDatetime(date);
       // vote.setRating(star);
       // vote.setCandidateId(candidate);
       // vote.setVoterId(voter);

       // vsi.insertVote(vote);

        return "index";
    }

    @GetMapping(value = "/showVotes")
    public String showMyVotes(ModelMap mm, HttpSession session) {
        User user = (User) session.getAttribute("user");
     //   List<Pollvote> lp = vsi.findMyVotes(user);
     //   if (lp.isEmpty()) {
            return "index";
        }
     //   mm.addAttribute("myVotes", lp);
     //   System.out.println("");
     //   return "myVotes";
   // }

    @ResponseBody
    @PostMapping(value = "/checkUsername/{username}")
    public boolean checkUsername(@PathVariable(name = "username") String username) {
        User user = usi.getUserByUsername(username);

        return (user != null);
    }

    
    
}
