package com.springboot.blog.controller;

import com.springboot.blog.data.entity.Profile;
import com.springboot.blog.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Profile> profiles = profileService.getAllProfiles();
        model.addAttribute("profiles", profiles);
        return "index";
    }

    @GetMapping("/profiles/create")
    public String showCreateProfileForm(Model model) {
        model.addAttribute("profile", new Profile());
        return "create_profile";
    }

    @PostMapping("/profiles/save")
    public String saveProfile(Profile profile, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String uploadDir = "src/main/resources/static/uploads/";
            File uploadDirFile = new File(uploadDir);
            if (!uploadDirFile.exists()) {
                uploadDirFile.mkdirs();
            }
            try {
                file.transferTo(new File(uploadDir + fileName));
                profile.setImageFiled(fileName.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        profile.setModifiedAt(LocalDateTime.now());
        profileService.saveProfile(profile);
        return "redirect:/";
    }
}
