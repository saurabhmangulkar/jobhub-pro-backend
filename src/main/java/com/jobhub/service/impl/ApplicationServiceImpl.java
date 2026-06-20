package com.jobhub.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jobhub.entity.Application;
import com.jobhub.entity.Job;
import com.jobhub.entity.User;
import com.jobhub.repository.ApplicationRepository;
import com.jobhub.repository.JobRepository;
import com.jobhub.repository.UserRepository;
import com.jobhub.service.ApplicationService;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;
    private final JobRepository jobRepository;

    public ApplicationServiceImpl(
            ApplicationRepository applicationRepository,
            UserRepository userRepository,
            JobRepository jobRepository) {

        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
    }

    
    @Override
    public Application applyForJob(Long userId, Long jobId) {

        User user = userRepository.findById(userId).orElse(null);

        Job job = jobRepository.findById(jobId).orElse(null);

        System.out.println("User = " + user);
        System.out.println("Job = " + job);

        if (user == null || job == null) {
            return null;
        }

        if (applicationRepository.existsByUser_IdAndJob_Id(userId, jobId)) {
            throw new RuntimeException("You have already applied for this job");
        }

        Application application = new Application();

        application.setUser(user);
        application.setJob(job);
        application.setStatus("APPLIED");

        return applicationRepository.save(application);
    }

    @Override
    public List<Application> getApplicationsByUser(Long userId) {
        return applicationRepository.findByUser_Id(userId);
    }

    
    @Override
    public List<Application> getApplicationsByJob(Long jobId) {
        return applicationRepository.findByJob_Id(jobId);
    }
    @Override
    public Application updateApplicationStatus(
            Long applicationId,
            String status) {

        Application application =
                applicationRepository
                        .findById(applicationId)
                        .orElse(null);

        if (application == null) {
            return null;
        }

        application.setStatus(status);

        return applicationRepository.save(application);
    }
    
}