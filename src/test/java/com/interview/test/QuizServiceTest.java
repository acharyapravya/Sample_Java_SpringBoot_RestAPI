package com.interview.test;

import com.interview.test.exceptions.QuizNotFoundException;
import com.interview.test.model.APIQuiz;
import com.interview.test.model.APIResponse;
import com.interview.test.service.APIService;
import com.interview.test.service.QuizService;
import com.interview.test.service.impl.QuizServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {QuizServiceImpl.class})
public class QuizServiceTest {

    @Autowired
    private QuizService quizService;

    @MockBean
    private APIService apiService;

    @Test
    public void testQuizService(){
        when(apiService.triggerAPI(any(),any())).thenReturn(mockData());
        try {
            Assertions.assertNotNull(quizService.getQuizzes());
        } catch (QuizNotFoundException e) {
            Assertions.fail();
        }
    }

    private CompletableFuture<APIResponse> mockData(){
        return CompletableFuture.supplyAsync(() -> {
            APIResponse response=new APIResponse();
            APIQuiz quiz=new APIQuiz();
            quiz.setCategory("Entertainment");
            quiz.setDifficulty("medium");
            quiz.setCorrectAnswer("1");
            quiz.setIncorrectAnswers(new ArrayList<>(Arrays.asList("2","3","4")));
            quiz.setQuestion("Question?");
            response.setResults(Collections.singletonList(quiz));
            return response;
        });
    }
}
