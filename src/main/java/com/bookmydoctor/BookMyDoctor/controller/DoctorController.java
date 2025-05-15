package com.bookmydoctor.BookMyDoctor.controller;

import com.bookmydoctor.BookMyDoctor.dto.DoctorRequestDTO;
import com.bookmydoctor.BookMyDoctor.response.ApiResponse;
import com.bookmydoctor.BookMyDoctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @RequestMapping("/mock")
    public ResponseEntity<?> mockDoctor(){
        DoctorRequestDTO doctorRequestDTO = new DoctorRequestDTO();
        doctorRequestDTO.setDoctorName("Vikram");
        doctorRequestDTO.setDoctorSpeciality("Pulmonologist");
        doctorRequestDTO.setGender("Male");
        doctorRequestDTO.setAge(29);
        doctorRequestDTO.setEmail("viki@gmail.com");
        doctorRequestDTO.setPassword("vikram@123");
        doctorRequestDTO.setPhoneNo(9786453120l);
        doctorRequestDTO.setRole("Doctor");

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(doctorRequestDTO);
    }


    @PostMapping("save-doctor")
    public ResponseEntity<?> saveUser(@RequestBody DoctorRequestDTO doctorRequestDTO){

        String id=doctorService.save(doctorRequestDTO);

        ApiResponse apiResponse=new ApiResponse();

        apiResponse.setHttpStatus(HttpStatus.ACCEPTED);
        apiResponse.setMessage("Doctor saved successfully");
        apiResponse.setData(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponse);
    }
}
