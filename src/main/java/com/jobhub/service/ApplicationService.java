package com.jobhub.service;

import java.util.List;

import com.jobhub.entity.Application;

public interface ApplicationService {

    Application applyForJob(Long userId, Long jobId);

    List<Application> getApplicationsByUser(Long userId);

    List<Application> getApplicationsByJob(Long jobId);
    Application updateApplicationStatus(
            Long applicationId,
            String status);
    
}