package com.bookmydoctor.BookMyDoctor.service;

import com.bookmydoctor.BookMyDoctor.dto.DoctorRequestDTO;
import com.bookmydoctor.BookMyDoctor.dto.UserRequestDTO;
import com.bookmydoctor.BookMyDoctor.entity.Doctor;
import com.bookmydoctor.BookMyDoctor.entity.User;
import com.bookmydoctor.BookMyDoctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService implements BookMyDoctorService{
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public String save(Object object) {
        DoctorRequestDTO doctorRequestDTO = (DoctorRequestDTO) object;
        Doctor doctor = Doctor.builder().doctorName(doctorRequestDTO.getDoctorName())
                .doctorSpeciality(doctorRequestDTO.getDoctorSpeciality())
                .gender(doctorRequestDTO.getGender())
                .age(doctorRequestDTO.getAge())
                .email(doctorRequestDTO.getEmail())
                .password(doctorRequestDTO.getPassword())
                .role(doctorRequestDTO.getRole())
                .phoneNo(doctorRequestDTO.getPhoneNo())
                .build();
        Doctor savedDoctor = doctorRepository.save(doctor);
        return savedDoctor.getDoctorId() + "";
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
