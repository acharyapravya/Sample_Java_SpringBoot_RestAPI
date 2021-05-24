package com.interview.test.controller;

import com.interview.test.exceptions.QuizNotFoundException;
import com.interview.test.model.Response;
import com.interview.test.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/quiz")
    public ResponseEntity<Response> getQuizzes() throws QuizNotFoundException {
        return new ResponseEntity<>(quizService.getQuizzes(), HttpStatus.OK);
    }
}
