package com.springboot.blog.controller;

import com.springboot.blog.data.dto.UserRequestDto;
import com.springboot.blog.data.entity.User;
import com.springboot.blog.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

// GET
    @GetMapping("/signup")
    public String signup(){return  "signup"; }

    @GetMapping("/signin")
    public String signin() {return "signin"; }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response,
                SecurityContextHolder.getContext().getAuthentication()
        );
        return "redirect:/user/signin";
    }

//    POST
    @PostMapping("/signup")
    public String signup(
//            @RequestParam("name") String name,
//            @RequestParam("email") String email,
//            @RequestParam("password") String password,
//            @RequestParam("rePassword") String rePassword
           UserRequestDto userRequestDto
    ){
        User createdUser = userService.createUser(userRequestDto);

        return "redirect:/user/signin";
    }


}
