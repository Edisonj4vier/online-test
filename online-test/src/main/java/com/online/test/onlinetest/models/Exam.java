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
    @Column(name = "TITLE", nullable = false, length = 100)
    private String title;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "TIME_LIMIT")
    private int timeLimit;
    @Column(name = "MINIMUN_PASSING_SCORE", precision = 4, scale = 2)
    private double minimunPassingScore;
    @Column(name = "NUMBER_OF_QUESTION")
    private int numberOFQuestuion;
    @Column(name = "INSTRUCTION")
    private String instructions;

    @OneToMany(mappedBy = "exam") //Nombre de atributo en la clase
    private List<Question> questions;
    
}
