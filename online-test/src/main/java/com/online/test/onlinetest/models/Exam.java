package com.online.test.onlinetest.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TBL_EXAMS")
@Getter
@Setter

public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name ="TITLE",nullable = false )
    private String title;

    @Column(name ="DESCRIPTION" )
    private String description;

    @Column(name ="TIME_LIMIT" )
    private int timeLimit;

    @Column(name ="MINIMUM_PASSING_SCORE", precision = 4, scale = 2)
    private double minimumPassingScore;

    @Column(name ="NUMBER_OF_QUESTION")
    private int numberOfQuestion;
    
    @Column(name ="INSTRUCTIONS" )
    private String instructions;

    @OneToMany(mappedBy = "exam")//debe ir el nombre del atributo de la clase B
    private List<Question> question;

}
