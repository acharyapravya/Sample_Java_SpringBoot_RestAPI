package com.interview.test.service.impl;

import com.interview.test.model.APIResponse;
import com.interview.test.service.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class APIServiceImpl implements APIService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String BASE_URL="https://opentdb.com/api.php";

    @Override
    public CompletableFuture<APIResponse> triggerAPI(String amount, String category) {
        return CompletableFuture.supplyAsync(() -> {
            String url=BASE_URL+"?amount={amount}&category={category}";
            Map<String,String> variable=new HashMap<>();
            variable.put("amount",amount);
            variable.put("category",category);
            ResponseEntity<APIResponse> response = restTemplate
                    .getForEntity(url, APIResponse.class,variable);
            return response.getBody();
        });
    }
}
