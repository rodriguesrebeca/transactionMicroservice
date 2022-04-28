package com.exercises.transaction.service.impl;

import com.exercises.transaction.dto.account.Account;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetAccount {

    public Account[] execute(String number){

        String url = "http://localhost:8090/account/all/{number}";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);

        ResponseEntity<Account[]> account = restTemplate.exchange(url,
                HttpMethod.GET,
                entity,
                Account[].class,
                number);

        if(account.getStatusCode().isError()){
            return null;
        }
        return account.getBody();
    }
}
