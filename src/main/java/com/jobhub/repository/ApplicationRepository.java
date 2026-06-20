package com.jobhub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobhub.entity.Application;

public interface ApplicationRepository
        extends JpaRepository<Application, Long> {

    List<Application> findByUser_Id(Long userId);

    List<Application> findByJob_Id(Long jobId);
    boolean existsByUser_IdAndJob_Id(Long userId, Long jobId);
}