package com.jobhub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobhub.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
	 List<Job> findByTitleContainingIgnoreCase(
	            String keyword);
}
