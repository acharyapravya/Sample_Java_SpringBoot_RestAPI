package com.interview.test.service.impl;

import com.interview.test.exceptions.QuizNotFoundException;
import com.interview.test.model.APIResponse;
import com.interview.test.model.QuizResponse;
import com.interview.test.model.Response;
import com.interview.test.service.APIService;
import com.interview.test.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private APIService apiService;

    @Override
    public Response getQuizzes() throws QuizNotFoundException {
        List<CompletableFuture<APIResponse>> completableFutures = Arrays.asList(
                apiService.triggerAPI("5", "11"),
                apiService.triggerAPI("5", "12"));

        List<QuizResponse> quizzes = completableFutures.stream()
                .map(CompletableFuture::join)
                .map(APIResponse::getResults)
                .flatMap(Collection::stream)
                .map(QuizResponse::new)
                .collect(Collectors.toList());
        if(quizzes.size() == 0){
            throw new QuizNotFoundException("No quizzes were identified");
        }
        return new Response(quizzes);
    }


}
