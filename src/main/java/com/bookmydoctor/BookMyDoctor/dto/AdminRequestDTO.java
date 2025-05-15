package com.bookmydoctor.BookMyDoctor.dto;

import lombok.Data;

@Data
public class AdminRequestDTO {
    private String adminName;
    private String gender;
    private int age;
    private String email;
    private String password;
    private long phoneNo;
    private String role;
}
