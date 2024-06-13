package com.springboot.blog.controller;

import com.springboot.blog.data.entity.Post;
import com.springboot.blog.service.PostService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Getter
@Setter
@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public String viewHomePage(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/posts/create")
    public String showCreatePostForm(Model model) {
        model.addAttribute("post", new Post());
        return "create_post";
    }

    @PostMapping("/posts/save")
    public String savePost(Post post, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String uploadDir = "uploads/";
            try {
                file.transferTo(new File(uploadDir + fileName));
                post.setImageFiled(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        postService.savePost(post);
        return "redirect:/posts";
    }
}
