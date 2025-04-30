package com.example.Lombok.service;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class WithoutClass {

    private static final String BASE_URL = "https://reqres.in/api/";
    private final RestTemplate restTemplate;

    public WithoutClass(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public Map<String, Object> fetchUsersDataOnly() {
        Map<String, String> params = new HashMap<>();
        params.put("page", "2");
        Map<String, Object> response = fetchDynamicGet("users", params);
        Map<String, Object> result = new HashMap<>();
        if (response != null && response.containsKey("data"))
        {
            result.put("data", response.get("data"));
        } else
        {
            result.put("error", "Data not found in response");
            result.put("message", "The 'data' key was not found in the response from the server.");
        }
        return result;

    }
    public Map<String, Object> fetchUsersFull() {
        Map<String, String> params = new HashMap<>();
        params.put("page", "2");
        return fetchDynamicGet("users", params);
    }


    public Map<String, Object> fetchUnknownList() {
        return fetchDynamicGet("unknown", null);
    }


    public Map<String, Object> postNewUser(Map<String, Object> requestBody) {
        return postDynamicUser("users", requestBody);
    }


    public Map<String, Object> fetchDynamicGet(String endpoint, Map<String, String> queryParams) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(BASE_URL + endpoint);
        if (queryParams != null&&queryParams.isEmpty())
        {
            queryParams.forEach(builder::queryParam);
        }
        else
        {

            System.out.println("No query parameters provided for the endpoint: " + endpoint);
        }
        String finalUrl = builder.toUriString();
        ParameterizedTypeReference<Map<String, Object>> responseType = new ParameterizedTypeReference<Map<String, Object>>() {};
        ResponseEntity<Map<String, Object>> response = restTemplate.exchange(finalUrl, HttpMethod.GET, null, responseType);
        return response.getBody();
    }

      public Map<String, Object> postDynamicUser(String endpoint, Map<String, Object> requestBody)
      {

        String url = BASE_URL + endpoint;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-api-key", "reqres-free-v1");
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);
        ParameterizedTypeReference<Map<String, Object>> responseType = new ParameterizedTypeReference<Map<String, Object>>() {};
        ResponseEntity<Map<String, Object>> response = restTemplate.exchange(url, HttpMethod.POST, entity, responseType);
        return response.getBody();
    }
}
