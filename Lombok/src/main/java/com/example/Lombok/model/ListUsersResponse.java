package com.example.Lombok.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListUsersResponse {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<UserDetails> data;
    private Support support;
}



