package com.interview.test.service;

import com.interview.test.exceptions.QuizNotFoundException;
import com.interview.test.model.Response;

public interface QuizService {

    Response getQuizzes() throws QuizNotFoundException;

}
