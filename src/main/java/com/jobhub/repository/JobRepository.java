package com.jobhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobhub.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

}