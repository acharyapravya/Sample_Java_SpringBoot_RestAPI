package com.interview.test.service;

import com.interview.test.model.APIResponse;

import java.util.concurrent.CompletableFuture;

public interface APIService {
    CompletableFuture<APIResponse> triggerAPI(String amount, String category);
}
