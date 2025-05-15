package com.bookmydoctor.BookMyDoctor.controller;

import com.bookmydoctor.BookMyDoctor.dto.UserRequestDTO;
import com.bookmydoctor.BookMyDoctor.dto.UserResponseDTO;
import com.bookmydoctor.BookMyDoctor.entity.User;
import com.bookmydoctor.BookMyDoctor.response.ApiResponse;
import com.bookmydoctor.BookMyDoctor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired(required = true)
    private UserService userService;

    @RequestMapping("/mock")
    public ResponseEntity<?> mockUser(){
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setUserName("Hariharan.K");
        userRequestDTO.setAge(29);
        userRequestDTO.setGender("Male");
        userRequestDTO.setEmail("hari@gmail.com");
        userRequestDTO.setPassword("hari@123");
        userRequestDTO.setRole("User");
        userRequestDTO.setPhoneNo(9876543210l);


        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userRequestDTO);
    }

    @PostMapping("save-user")
    public ResponseEntity<?> saveUser(@RequestBody UserRequestDTO userRequestDTO){

        String id=userService.save(userRequestDTO);

        ApiResponse apiResponse=new ApiResponse();

        apiResponse.setHttpStatus(HttpStatus.ACCEPTED);
        apiResponse.setMessage("Employee saved successfully");
        apiResponse.setData(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponse);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody UserRequestDTO userRequestDTO){
        String updatedId = userService.update(id, userRequestDTO);
        ApiResponse response = new ApiResponse();
        response.setMessage("Employee updated successfully");
        response.setHttpStatus(HttpStatus.OK);
        response.setData(updatedId);

        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id")int id){
        userService.deleteById(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<UserResponseDTO> getEmployee(@PathVariable("id")int id){
        UserResponseDTO userResponseDTO = (UserResponseDTO) userService.getById(id);
        return ResponseEntity.ok(userResponseDTO);
    }
    @GetMapping("/get-all")
    public ResponseEntity<?> getAll(){
        List<User> all = userService.getAll();
        return ResponseEntity.ok(all);
    }

}
