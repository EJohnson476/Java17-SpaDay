package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {
    @GetMapping("add")
    public String displayUserForm()
    {
        return "user/add";
    }
    @PostMapping("create")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify)
    {
        if(verify.equalsIgnoreCase(user.getPassword())) {
            return "redirect:/";
        }

            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            model.addAttribute("error");
            return "/user/add";
    }
}
