package org.akash.controller;

import org.akash.dto.AppUser;
import org.akash.dto.AuthRequest;
import org.akash.dto.CreateUserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

public class UserController {
    RestTemplate restTemplate;

    @Autowired
    public UserController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/")
    public String availableToAll() {
        String apiUrl = "http://localhost:8081/";
        return restTemplate.getForObject(apiUrl, String.class);
    }
    @PostMapping("/createUser")
    public AppUser createUserFromAnotherService(@RequestBody CreateUserReq req) {
        String createUserUrl = "http://localhost:8081/app-auth/createUser";
        return restTemplate.postForObject(createUserUrl, req, AppUser.class);
    }

    @GetMapping("/generateToken")
    public String generateToken(@RequestBody AuthRequest authRequest) {
        String authUrl = "http://localhost:8081/app-auth/token";
        ResponseEntity<String> response = restTemplate.postForEntity(authUrl, authRequest, String.class);
        return response.getBody();
    }

}
