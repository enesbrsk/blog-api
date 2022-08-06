package com.services.rest.blogapi.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PostResponse {

    private Long id;
    private String title;
    private String description;
    private String text;
    private LocalDate createDateTime;
    private LocalDate updateDateTime;
    private String imageName;

}
