package com.example.Lombok.service;
import com.example.Lombok.model.*;
import com.example.Lombok.repository.PutRepo;
import com.example.Lombok.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class FetchService
{
    private  final RestTemplate restTemplate=new RestTemplate();
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PutRepo putRepo;
    public ListUsersResponse getUserByApi() {
        String url = "https://reqres.in/api/users?page=2";
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", "reqres-free-v1");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<ListUsersResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                ListUsersResponse.class
        );
        return response.getBody();
    }

    public UserResponseForSingle getUserByApiId(Integer id)
    {
        String url = "https://reqres.in/api/users/"+id;
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", "reqres-free-v1");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<UserResponseForSingle> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, UserResponseForSingle.class);
        return  response.getBody();
    }
    public ListUsersResponse listUsers()
    {
        String url ="https://reqres.in/api/unknown";
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", "reqres-free-v1");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<ListUsersResponse> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, ListUsersResponse.class);
        return response.getBody();
    }
    public PutResponse postUser(PutResponse putResponse) {
        String url = "https://reqres.in/api/users";
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", "reqres-free-v1");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Fetch user data from external API
        ResponseEntity<PutResponse> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, PutResponse.class);

        PutResponse fetchedUser = response.getBody();

        if (fetchedUser != null)
            putRepo.save(fetchedUser);

        return fetchedUser;
    }

    public List<UserDetails> delayUser()
    {
        String url ="https://reqres.in/api/users?delay=3";
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", "reqres-free-v1");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<UserResponse> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, UserResponse.class);
        return response.getBody().getData();
    }
    public List<UserDetails> putUser()
    {
        String url ="https://reqres.in/api/users/2";
        HttpHeaders headers =new HttpHeaders();
        headers.set("x-api-key", "reqres-free-v1");
        HttpEntity<String> entity =new HttpEntity<>(headers);
        ResponseEntity<UserResponse> response =restTemplate.exchange(url,HttpMethod.PUT,entity, UserResponse.class);
        return  response.getBody().getData();
    }
    public List<UserDetails> patchUser()
    {
        String url="https://reqres.in/api/users/2";
        HttpHeaders headers =new HttpHeaders();
        headers.set("x-api-key","reqres-free-v1");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<UserResponse> response = restTemplate.exchange(url,HttpMethod.PATCH,entity,UserResponse.class);
        return response.getBody().getData();
    }
    public void deleteUser()
    {
        String url ="https://reqres.in/api/users/2";
        HttpHeaders headers =new HttpHeaders();
        headers.set("x-api-key","reqres-free-v1");
        HttpEntity<String> entity=new HttpEntity<>(headers);
        ResponseEntity<UserResponse> response= restTemplate.exchange(url,HttpMethod.DELETE,entity, UserResponse.class);

    }


}
