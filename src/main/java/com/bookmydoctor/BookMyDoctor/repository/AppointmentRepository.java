package com.bookmydoctor.BookMyDoctor.repository;

import com.bookmydoctor.BookMyDoctor.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
