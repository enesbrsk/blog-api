package com.services.rest.blogapi.dto;

import lombok.Data;

@Data
public class PostRequest {
    private String title;
    private String description;
    private String text;
    private String imageName;
}
