package com.example.businessserver.service;

import com.example.businessserver.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticationServerProxy {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${auth.server.base.url}")
    private String baseUrl;

    public void setAuth(String username, String password) {

        String url = String.format("%s/login", baseUrl);
        User payload = new User();

        payload.setUsername(username);
        payload.setPassword(password);

        HttpEntity<User> request = new HttpEntity<>(payload);
        restTemplate.postForEntity(url, request, Void.class);

    }

    public boolean sendOtp(String username, String otp) {

        String url = String.format("%s/otp/verify", baseUrl);
        User payload = new User();

        payload.setUsername(username);
        payload.setCode(otp);

        HttpEntity<User> request = new HttpEntity<>(payload);
        ResponseEntity<Void> response = restTemplate.postForEntity(url, request, Void.class);

        return response.getStatusCode().equals(HttpStatus.OK);

    }

}
