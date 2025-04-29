package com.example.Lombok.service;
import com.example.Lombok.model.UserDetails;
import com.example.Lombok.model.UserResponse;
import com.example.Lombok.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class FetchService
{
    private  final RestTemplate restTemplate=new RestTemplate();
    @Autowired
    private UserRepo userRepo;

    public List<UserDetails> getUserByApi() {
        String url = "https://reqres.in/api/users?page=2";
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", "reqres-free-v1");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<UserResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                UserResponse.class
        );

        return response.getBody().getData();
    }

    public List<UserDetails> getUserByApiId(Integer id) {
        String url = "https://reqres.in/api/users/" + id;
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", "reqres-free-v1");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<UserResponse> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, UserResponse.class);
        return response.getBody().getData();
    }
    public List<UserDetails> listUsers()
    {
        String url ="https://reqres.in/api/unknown";
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", "reqres-free-v1");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<UserResponse> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, UserResponse.class);
        return response.getBody().getData();
    }
    public List<UserDetails> postUser()
    {
        String url ="https://reqres.in/api/users";
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", "reqres-free-v1");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<UserResponse> response = restTemplate.exchange(
                url, HttpMethod.POST, entity, UserResponse.class);
        return response.getBody().getData();
    }
    public String delayUser()
    {
        String url ="https://reqres.in/api/users?delay=3";
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", "reqres-free-v1");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }

}
