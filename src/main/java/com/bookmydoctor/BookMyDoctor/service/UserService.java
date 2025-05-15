package com.bookmydoctor.BookMyDoctor.service;

import com.bookmydoctor.BookMyDoctor.dto.UserRequestDTO;
import com.bookmydoctor.BookMyDoctor.dto.UserResponseDTO;
import com.bookmydoctor.BookMyDoctor.entity.User;
import com.bookmydoctor.BookMyDoctor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements BookMyDoctorService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public String save(Object object) {
        UserRequestDTO userRequestDTO = (UserRequestDTO)object;
        User user = User.builder().userName(userRequestDTO.getUserName())
                .gender(userRequestDTO.getGender())
                .age(userRequestDTO.getAge())
                .email(userRequestDTO.getEmail())
                .password(userRequestDTO.getPassword())
                .role(userRequestDTO.getRole())
                .phoneNo(userRequestDTO.getPhoneNo())
                .build();
        User savedUser = userRepository.save(user);
        return savedUser.getUserId() + "";
    }

    @Override
    public String update(int id,Object object) {
        UserRequestDTO userRequestDTO = (UserRequestDTO)object;
        return "";
    }

    @Override
    public Object getById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        UserResponseDTO dto = new UserResponseDTO();
        dto.setUserName(user.getUserName());
        dto.setGender(user.getGender());
        dto.setEmail(user.getEmail());
        dto.setAge(user.getAge());

        return dto;
    }

    @Override
    public List<User> getAll() {
        return List.of();
    }

    @Override
    public void deleteById(int id) {

    }
}
