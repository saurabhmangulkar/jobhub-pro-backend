package com.jobhub.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.jobhub.entity.Application;
import com.jobhub.service.ApplicationService;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(
            ApplicationService applicationService) {

        this.applicationService = applicationService;
    }

    @PostMapping("/{userId}/{jobId}")
    public Application applyForJob(
            @PathVariable Long userId,
            @PathVariable Long jobId) {

        return applicationService.applyForJob(
                userId,
                jobId);
    }

    @GetMapping("/user/{userId}")
    public List<Application> getApplicationsByUser(
            @PathVariable Long userId) {

        return applicationService
                .getApplicationsByUser(userId);
    }

    @GetMapping("/job/{jobId}")
    public List<Application> getApplicationsByJob(
            @PathVariable Long jobId) {

        return applicationService
                .getApplicationsByJob(jobId);
    }
    @PutMapping("/{id}/status")
    public Application updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return applicationService
                .updateApplicationStatus(
                        id,
                        status);
    }
}