package com.jobhub.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jobhub.entity.Job;
import com.jobhub.repository.JobRepository;
import com.jobhub.service.JobService;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public Job updateJob(Long id, Job job) {

        Job existingJob = jobRepository.findById(id).orElse(null);

        if (existingJob == null) {
            return null;
        }

        existingJob.setTitle(job.getTitle());
        existingJob.setDescription(job.getDescription());
        existingJob.setLocation(job.getLocation());
        existingJob.setSalary(job.getSalary());
        existingJob.setExperienceRequired(job.getExperienceRequired());
        existingJob.setEmploymentType(job.getEmploymentType());
        existingJob.setStatus(job.getStatus());

        return jobRepository.save(existingJob);
    }

    @Override
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}