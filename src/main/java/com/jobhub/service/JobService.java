package com.jobhub.service;

import java.util.List;

import com.jobhub.entity.Job;

public interface JobService {

    Job createJob(Job job);

    List<Job> getAllJobs();

    Job getJobById(Long id);

    Job updateJob(Long id, Job job);

    void deleteJob(Long id);
}