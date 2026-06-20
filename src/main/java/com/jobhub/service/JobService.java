package com.jobhub.service;

import java.util.List;

import com.jobhub.entity.Job;
import org.springframework.data.domain.Page;

public interface JobService {

    Job createJob(Job job);


    Page<Job> getJobs(int page, int size);
    List<Job> getAllJobs();

    Job getJobById(Long id);

    Job updateJob(Long id, Job job);

    void deleteJob(Long id);
    List<Job> searchJobs(String keyword);
}