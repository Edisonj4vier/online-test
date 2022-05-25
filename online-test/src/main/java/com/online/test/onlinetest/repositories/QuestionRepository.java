package com.online.test.onlinetest.repositories;

import com.online.test.onlinetest.models.Question;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository <Question,Long> {
    //DAO DATA ACCESS OBJECT 
}
