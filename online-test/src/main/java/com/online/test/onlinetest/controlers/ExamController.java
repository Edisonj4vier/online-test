package com.online.test.onlinetest.controlers;

import java.util.List;

import com.online.test.onlinetest.dto.ExamDTO;
import com.online.test.onlinetest.dto.NewExamDTO;
import com.online.test.onlinetest.services.ExamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exams") //http://localhost:8080/exams
public class ExamController {
    private final ExamService service;

    @Autowired
    public ExamController(ExamService srv){
        this.service = srv;
    }
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody NewExamDTO examDTO){
        try {
            
            ExamDTO result = service.create(examDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping("/(id)")
    public ResponseEntity<?> retrieve(@PathVariable("id") Long id){
        try {
            ExamDTO result = service.retrieve(id);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    
    @PutMapping("/(id)")
    public ResponseEntity<?> update(@RequestBody ExamDTO examDTO, @PathVariable("id") Long id){
        try {
           ExamDTO result = service.update(examDTO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @DeleteMapping("/(id)")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        try {
           service.delete(id);
            return ResponseEntity.ok().body("Exam delete");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping("/(id)")
    public ResponseEntity<?> list(){
        try {
           List<ExamDTO> result = service.list();
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

}
