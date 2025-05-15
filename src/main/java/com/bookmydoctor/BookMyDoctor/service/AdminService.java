package com.bookmydoctor.BookMyDoctor.service;

import com.bookmydoctor.BookMyDoctor.dto.AdminRequestDTO;
import com.bookmydoctor.BookMyDoctor.entity.Admin;
import com.bookmydoctor.BookMyDoctor.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements BookMyDoctorService{

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public String save(Object object) {
        AdminRequestDTO adminRequestDTO = (AdminRequestDTO)object;
        Admin admin = Admin.builder().adminName(adminRequestDTO.getAdminName())
                .gender(adminRequestDTO.getGender())
                .age(adminRequestDTO.getAge())
                .email(adminRequestDTO.getEmail())
                .password(adminRequestDTO.getPassword())
                .phoneNo(adminRequestDTO.getPhoneNo())
                .role(adminRequestDTO.getRole()).build();
        Admin savedAdmin = adminRepository.save(admin);
        return savedAdmin.getAdminId() + "";
    }

    @Override
    public String update(int id, Object object) {
        return "";
    }

    @Override
    public Object getById(int id) {
        return null;
    }

    @Override
    public List<?> getAll() {
        return List.of();
    }

    @Override
    public void deleteById(int id) {

    }
}
