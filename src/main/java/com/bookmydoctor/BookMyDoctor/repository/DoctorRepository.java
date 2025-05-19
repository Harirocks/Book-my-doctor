package com.bookmydoctor.BookMyDoctor.repository;

import com.bookmydoctor.BookMyDoctor.dto.DoctorSummary;
import com.bookmydoctor.BookMyDoctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    @Query("SELECT new com.bookmydoctor.BookMyDoctor.dto.DoctorSummary(d.doctorName, d.doctorSpeciality, d.phoneNo) FROM Doctor d")
    List<DoctorSummary> findAllDoctorSummaries();
}
