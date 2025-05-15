package com.bookmydoctor.BookMyDoctor.controller;

import com.bookmydoctor.BookMyDoctor.dto.AdminRequestDTO;
import com.bookmydoctor.BookMyDoctor.dto.UserRequestDTO;
import com.bookmydoctor.BookMyDoctor.response.ApiResponse;
import com.bookmydoctor.BookMyDoctor.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/mock")
    public ResponseEntity<?> mockUser(){
        AdminRequestDTO adminRequestDTO = new AdminRequestDTO();
        adminRequestDTO.setAdminName("Vignesh.D.V");
        adminRequestDTO.setAge(30);
        adminRequestDTO.setGender("Male");
        adminRequestDTO.setEmail("vignesh@gmail.com");
        adminRequestDTO.setPassword("vignesh@123");
        adminRequestDTO.setRole("Admin");
        adminRequestDTO.setPhoneNo(9876543456l);


        return ResponseEntity.status(HttpStatus.ACCEPTED).body(adminRequestDTO);
    }

    @PostMapping("save-admin")
    public ResponseEntity<?> saveAdmin(@RequestBody AdminRequestDTO adminRequestDTO){
        String id = adminService.save(adminRequestDTO);
        ApiResponse apiResponse=new ApiResponse();

        apiResponse.setHttpStatus(HttpStatus.ACCEPTED);
        apiResponse.setMessage("Admin saved successfully");
        apiResponse.setData(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponse);
    }
}
