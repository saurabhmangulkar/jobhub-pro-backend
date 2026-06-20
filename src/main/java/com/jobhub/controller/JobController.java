package com.jobhub.controller;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import com.jobhub.entity.Job;
import com.jobhub.service.JobService;
import org.springframework.data.domain.Page;
@RestController
@RequestMapping("/api/jobs")
public class JobController {
	@PreAuthorize("hasRole('RECRUITER') or hasRole('ADMIN')")
	@PostMapping
	public Job createJob(@Valid @RequestBody Job job) {
	    return jobService.createJob(job);
	}
	@PreAuthorize("hasRole('RECRUITER') or hasRole('ADMIN')")
	@PutMapping("/{id}")
	public Job updateJob(
	        @PathVariable Long id,
	        @RequestBody Job job) {

	    return jobService.updateJob(id, job);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public String deleteJob(@PathVariable Long id) {

	    jobService.deleteJob(id);

	    return "Job deleted successfully";
	}
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

//    @PostMapping
//    public Job createJob(@RequestBody Job job) {
//        return jobService.createJob(job);
//    }
    @GetMapping("/page")
    public Page<Job> getJobs(
            @RequestParam int page,
            @RequestParam int size) {

        return jobService.getJobs(page, size);
    }
    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }

//    @PutMapping("/{id}")
//    public Job updateJob(
//            @PathVariable Long id,
//            @RequestBody Job job) {
//
//        return jobService.updateJob(id, job);
//    }

//    @DeleteMapping("/{id}")
//    public String deleteJob(@PathVariable Long id) {
//
//        jobService.deleteJob(id);
//
//        return "Job deleted successfully";
//    }
    @GetMapping("/search")
    public List<Job> searchJobs(
            @RequestParam String keyword) {

        return jobService.searchJobs(keyword);
    }
}