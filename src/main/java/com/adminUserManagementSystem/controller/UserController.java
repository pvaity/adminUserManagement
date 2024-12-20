package com.adminUserManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.adminUserManagementSystem.beans.User;

import com.adminUserManagementSystem.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String viewProfile(Principal principal, Model model) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "user/profile";
    }

    @PostMapping("/edit")
    public String editProfile(Principal principal, @ModelAttribute User user) {
        User currentUser = userService.findByUsername(principal.getName());
        currentUser.setUsername(user.getUsername());
        currentUser.setPassword(user.getPassword());
        userService.updateUser(currentUser);
        return "redirect:/user/profile";
    }
}

