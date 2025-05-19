package com.bookmydoctor.BookMyDoctor.dto;

import lombok.Data;

@Data
public class DoctorSummary {
    private String doctorName;
    private String doctorSpeciality;
    private long phoneNo;

    // Constructor
    public DoctorSummary(String doctorName, String doctorSpeciality, long phoneNo) {
        this.doctorName = doctorName;
        this.doctorSpeciality = doctorSpeciality;
        this.phoneNo = phoneNo;
    }
}
