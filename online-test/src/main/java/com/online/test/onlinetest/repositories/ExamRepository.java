package com.online.test.onlinetest.repositories;

import com.online.test.onlinetest.models.Exam;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam,Long>{
    
}
