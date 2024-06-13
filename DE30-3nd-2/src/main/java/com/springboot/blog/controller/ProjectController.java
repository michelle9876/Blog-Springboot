package com.springboot.blog.controller;

import com.springboot.blog.data.entity.Project;
import com.springboot.blog.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    public String showProjectsPage() {
        return "projects";
    }

    @PostMapping("/projects/create")
    public String createProject(@RequestParam Long userId,
                                @RequestParam String projectTitle,
                                @RequestParam String contents,
                                @RequestParam(required = false) String urlLink,
                                @RequestParam("file") MultipartFile file) {
        // 파일 업로드 처리
        // 예시로 파일을 업로드 디렉토리에 저장하고 파일명을 프로젝트 객체에 저장합니다.
        String fileName = file.getOriginalFilename();
        String uploadDir = "/path/to/upload/directory";
        String filePath = uploadDir + "/" + fileName;

        // 프로젝트 생성 및 파일명 저장
        Project project = projectService.createProject(userId, projectTitle, contents, urlLink, fileName);

        // 파일 저장
        try {
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            // 파일 저장에 실패한 경우 예외 처리
            // 예시로는 간단하게 처리하였지만 실제 프로젝트에서는 좀 더 세밀한 예외 처리가 필요합니다.
            // 사용자에게 적절한 메시지를 반환하거나, 로깅하여 추적이 가능하도록 합니다.
            // return "redirect:/error"; // 에러 페이지로 리다이렉트
        }

        // 프로젝트 목록 페이지로 리다이렉트
        return "redirect:/projects";
    }
}