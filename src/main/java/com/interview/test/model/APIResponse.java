package com.interview.test.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class APIResponse {
    private List<APIQuiz> results;
    private int responseCode;

    public List<APIQuiz> getResults() {
        return results;
    }

    public void setResults(List<APIQuiz> results) {
        this.results = results;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
}
